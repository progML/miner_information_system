import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, throwError } from 'rxjs';
import {LocalStorageService} from 'ngx-webstorage';
import { retry, catchError } from 'rxjs/operators';
import {AuthService} from './service/auth.service';
import {Router} from '@angular/router';

@Injectable()
export class HttpClientInterceptor implements HttpInterceptor {

  constructor(private $localStorage: LocalStorageService, private authService: AuthService, private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const token = this.$localStorage.retrieve('authenticationToken');
    console.log('jwt token ' + token);

    if (token) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + token)
      });

      return next.handle(cloned)
        .pipe(
          catchError((error: HttpErrorResponse) => {
            console.log(error.statusText);
            if (error.statusText == 'Unknown Error') {
              this.authService.logout();
              this.router.navigateByUrl('/auth');
            } else {
              // server-side error
            }
            return throwError(error.error);
          })
        );
    } else {
      return next.handle(req);
    }
  }
}
