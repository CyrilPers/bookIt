import { Component, ViewChild } from '@angular/core';
import { ButtonComponent } from '../reusable/button/button.component';
import { FormsModule, NgForm} from '@angular/forms';
import { checkForm } from '../utils/checkPassword';
import {GestionCustomerService} from "../core/services/gestion-customer/gestion-customer.service";
import {Router} from "@angular/router";
import {Customer} from "../models/customer/customer";

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [ButtonComponent, FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  passwordErrors: String [] = [];
  formSubmitted: boolean = false;
  customer: Customer;
  @ViewChild('signInForm') signInForm: NgForm;

  constructor(private router: Router,
              private gestionCustomerService: GestionCustomerService) {}

  ngOnInit(): void {
    this.initCustomer(this.customer);
  }
  
  onSubmit = ():void => {
    this.checkPassword();
    this.formSubmitted = true;
    if (this.passwordErrors.length == 0) {
      this.gestionCustomerService.createCustomer(this.customer).subscribe(() =>
          this.router.navigate(["/sign-in"])
      );
    }
  }

  checkPassword = ():void => {
    this.passwordErrors = []
    if (this.signInForm.value.password) {
      this.passwordErrors = checkForm(this.signInForm.value.password)
    } else {
      this.passwordErrors.push('Veuillez entrer un mot de passe')
    }
  }

  private initCustomer(customer: Customer) {
    this.customer = new Customer();
  }
}
