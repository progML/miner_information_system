import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {MiningModel} from '../model/mining.model';

@Injectable({
  providedIn: 'root'
})
export class MiningService {
  private url = "http://localhost:8080/api/mining/";

  constructor(private httpClient: HttpClient) {
  }

  getAllMinings(id: number): Observable<Array<MiningModel>> {
    return this.httpClient.get<Array<MiningModel>>(this.url + 'all/' + id);
  }

}
