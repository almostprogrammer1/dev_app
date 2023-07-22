import { Component } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
  login: string = '';
  password: string = '';

  loginClicked() {
    console.log('Login:', this.login);
    console.log('Password:', this.password);
  }




}
