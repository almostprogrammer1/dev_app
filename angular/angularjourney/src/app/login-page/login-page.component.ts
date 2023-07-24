import { Component, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements AfterViewInit {
  ngAfterViewInit() {
    
    const signUpButton = document.getElementById('signUp') as HTMLElement;
    const signInButton = document.getElementById('signIn') as HTMLElement;
    const container = document.getElementById('container') as HTMLElement;

    signUpButton.addEventListener('click', handleClick);
    signInButton.addEventListener('click', handleClick);

    function handleClick() {
      container.classList.toggle("right-panel-active");
    }
  }
}