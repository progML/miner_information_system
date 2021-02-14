import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeliveryMinerService {

  private url = "http://localhost:8080/api/delivery/";

  constructor(private httpClient: HttpClient) {
  }

  doDelivery(minerId: number): Observable<any> {
    console.log(this.url + 'do/' + minerId);
    return this.httpClient.get(this.url + 'do/' + minerId, { responseType: 'text'});
  }

}
