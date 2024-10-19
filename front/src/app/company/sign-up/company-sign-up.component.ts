import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm} from '@angular/forms';
import {Router} from "@angular/router";
import {GestionCompanyService} from "../../core/services/gestion-company/gestion-company.service";
import {ButtonComponent} from "../../reusable/button/button.component";
import {Worker} from "../../models/worker/worker";
import {checkForm} from "../../utils/checkPassword";

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [ButtonComponent, FormsModule],
  templateUrl: './company-sign-up.component.html',
  styleUrl: './company-sign-up.component.css'
})
export class CompanySignUpComponent {
  passwordErrors: String [] = [];
  formSubmitted: boolean = false;
  worker: Worker;
  cguAccepted: boolean = false;
  @ViewChild('signInForm') signInForm: NgForm;

  constructor(private router: Router,
              private gestionCompanyService: GestionCompanyService) {}

  ngOnInit(): void {
    this.initCustomer(this.worker);
  }
  
  onSubmit = ():void => {
    this.checkPassword();
    this.formSubmitted = true;
    if (this.passwordErrors.length == 0) {
      this.gestionCompanyService.createCompany(this.worker).subscribe(() =>
          this.router.navigate(["/company/sign-in"])
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

  private initCustomer(worker: Worker) {
    this.worker = new Worker();
  }
}
