import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MinerModel } from '../model/miner.model';
import {MinerDeliveryResponseModel} from '../model/miner-delivery-response.model';

@Injectable({
  providedIn: 'root'
})
export class MinerService {
  private url = "http://localhost:8080/api/miner/";

  constructor(private httpClient: HttpClient) {
  }

  getMiner(id: number): Observable<MinerModel> {
    return this.httpClient.get<MinerModel>(this.url + 'get/' + id);
  }

  getMinersDelivery(brigadeId: number): Observable<Array<MinerDeliveryResponseModel>> {
    return this.httpClient.get<Array<MinerDeliveryResponseModel>>(this.url + 'all/' + brigadeId);
  }

}
