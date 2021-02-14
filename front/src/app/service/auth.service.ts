import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthModel } from '../model/auth.model';
import { Observable } from 'rxjs';
import { JwtAuthResponseModel } from '../model/jwt-auth-response.model';
import { map } from 'rxjs/operators';
import { LocalStorageService } from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = "http://localhost:8080/api/auth/";

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) {
  }

  login(authModel: AuthModel): Observable<boolean> {
    return this.httpClient.post<JwtAuthResponseModel>(this.url + 'login', authModel).pipe(map( data => {
      if ((data.authenticationToken == "") && (data.username == "")) {
        return false;
      } else {
        this.localStorageService.store('authenticationToken', data.authenticationToken);
        this.localStorageService.store('minerId', data.minerId);
        this.localStorageService.store('username', data.username);
        this.localStorageService.store('part', data.part);
        this.localStorageService.store('brigadeId', data.brigadeId);
        return true;
      }
    }));
  }

  isAuthenticated(): boolean {
    return this.localStorageService.retrieve('username') != null;
  }

  logout() {
    this.localStorageService.clear('authenticationToken');
    this.localStorageService.clear('minerId');
    this.localStorageService.clear('username');
    this.localStorageService.clear('part');
    this.localStorageService.clear('brigadeId');
  }

}
