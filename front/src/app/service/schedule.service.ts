import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ScheduleModel} from '../model/schedule.model';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  private url = "http://localhost:8080/api/schedule/";

  constructor(private httpClient: HttpClient) {
  }

  getSchedule(id: number): Observable<Array<ScheduleModel>> {
    return this.httpClient.get<Array<ScheduleModel>>(this.url + 'all/' + id);
  }

}
