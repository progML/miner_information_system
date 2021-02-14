import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthModel} from '../../model/auth.model';
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss', '../auth.component.scss']

})
export class LoginComponent {

  loginForm: FormGroup;
  authModel: AuthModel;
  isInvalid: boolean;
  isUserExist: boolean = true;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.formBuilder.group({
      username: ['', [ Validators.required, Validators.minLength(3), Validators.maxLength(16), Validators.pattern('^[a-z]+$') ]],
      password: ['', [ Validators.required, Validators.minLength(8), Validators.maxLength(20), Validators.pattern('[^а-я]+') ]]
    });

    this.authModel = {
      username: '',
      password: ''
    };
  }

  setValid(): boolean {
    this.isInvalid = (this.loginForm.controls['username'].invalid && this.loginForm.controls['username'].touched) ||
      (this.loginForm.controls['password'].invalid && this.loginForm.controls['password'].touched);
    return this.isInvalid;
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.authModel.username = this.loginForm.get('username').value;
      this.authModel.password = this.loginForm.get('password').value;

      this.authService.login(this.authModel).subscribe(data => {
        if (data) {
          console.log("login successful");
          this.router.navigateByUrl('/profile');
        } else {
          this.isUserExist = false;
          this.loginForm.controls['username'].setErrors({ 'invalid': true });
          this.loginForm.controls['username'].markAsUntouched();
          this.loginForm.controls['password'].markAsUntouched();
          this.loginForm.get('username').reset();
          this.loginForm.get('password').reset();
          console.log("login failed");
        }
      });
    } else {
      console.log('invalid form');
      this.isInvalid = true;
      this.loginForm.markAllAsTouched();
    }
  }

}
