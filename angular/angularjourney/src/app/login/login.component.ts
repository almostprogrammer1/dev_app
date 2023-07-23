import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  public loginInvalid: boolean = false;
  private formSubmitAttempt: boolean = false;

  constructor ( 
    private fb: FormBuilder,
  ) {   
  }

  async ngOnInit() {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  async onSubmit() {
    this.loginInvalid;
    this.formSubmitAttempt;
    /* Do dodania logika autoryzacyjna */
  }

}
