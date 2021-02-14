import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from 'ngx-webstorage';
import { Observable } from 'rxjs';
import {MagazineModel} from "../model/magazine.model";
import {MinerModel} from "../model/miner.model";
import {ManagingModel} from "../model/managing.model";


@Injectable({
  providedIn: 'root'
})

export class MagazineService{
  private url = "http://localhost:8080/api/magazine/";


  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) {
  }

  //Добавтьб метод add

  addMagazine(magazineModel: MagazineModel): Observable<MagazineModel>{
    return this.httpClient.post<MagazineModel>(this.url + 'add/', magazineModel);
  }

//Правильное решение
  getAllBrigade(brigadeId: number): Observable<Array<ManagingModel>>
  {
    return this.httpClient.get<Array<ManagingModel>>(this.url+'br/'+brigadeId)
  }


  getAllMagazine(id: number): Observable<Array<MagazineModel>>
  {
    return this.httpClient.get<Array<MagazineModel>>(this.url + 'all/'+ id);
  }


}
