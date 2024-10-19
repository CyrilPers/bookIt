import {Component, OnInit, ViewChild} from '@angular/core';
import { ButtonComponent } from '../reusable/button/button.component';
import { FormsModule, NgForm} from '@angular/forms';
import {GestionCustomerService} from "../core/services/gestion-customer/gestion-customer.service";
import {Router} from "@angular/router";
import {Customer} from "../models/customer/customer";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [ButtonComponent, FormsModule],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css',
})
export class SignInComponent implements OnInit{

  passwordErrors: String [] = [];
  customer: Customer;
  @ViewChild('signInForm') signInForm: NgForm;

  constructor(private router : Router,
              private gestionCustomerSvc: GestionCustomerService,
              private http: HttpClient) {
  }

  ngOnInit(): void {
    this.customer = new Customer();
  }
  
  onSubmit = ():void => {

    this.gestionCustomerSvc.loginCustomer(this.customer).subscribe(() =>
        this.router.navigate(["/profil"])
    );
  }
}
