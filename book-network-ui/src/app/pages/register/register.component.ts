import { Component } from '@angular/core';
import {RegistrationRequest} from "../../services/models/registration-request";
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {}

  registerRequest: RegistrationRequest = {email: "", firstName: "", lastName: "", password: ""};
  errorMessages: Array<string> = [];
  passwordConfirmation: string = "";
  hidePassword: boolean = true;
  hideConfirmation: boolean = true;

  register() {
    this.errorMessages = [];
    if (this.registerRequest.password !== this.passwordConfirmation) {
      this.errorMessages.push("Passwords do not match");
      return;
    }
    this.authenticationService.register({
      body: this.registerRequest
    }).subscribe({
      next: () => {
        this.router.navigate(["activate-account"])
      },
      error: (err) => {
        this.errorMessages = err.error.validationErrors;
      }
    })
  }

  login() {
    this.router.navigate(["login"]);
  }

  toggleShowConfirmation() {
    this.hideConfirmation = !this.hideConfirmation;
  }

  toggleShowPassword() {
    this.hidePassword = !this.hidePassword;
  }
}
