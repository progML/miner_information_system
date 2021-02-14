import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MessageMinerModel} from '../model/message-miner.model';

@Injectable({
  providedIn: 'root'
})
export class MessageMinerService {

  private url = "http://localhost:8080/api/message/";

  constructor(private httpClient: HttpClient) {
  }

  addMessage(messageMinerModel: MessageMinerModel): Observable<any> {
    return this.httpClient.post<MessageMinerModel>(this.url + 'add/', messageMinerModel);
  }

  getMinerMessages(minerId: number): Observable<Array<MessageMinerModel>> {
    return this.httpClient.get<Array<MessageMinerModel>>(this.url + 'all/' + minerId);
  }

}
