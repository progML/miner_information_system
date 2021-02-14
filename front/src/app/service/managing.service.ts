import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LocalStorageService} from "ngx-webstorage";
import {Observable} from "rxjs";
import {ManagingModel} from "../model/managing.model";
import {MinerModel} from "../model/miner.model";
import {BrigadeModel} from "../model/brigade.model";
import {MagazineModel} from "../model/magazine.model";


@Injectable({
  providedIn: 'root'
})

export class ManagingService{
  private url = "http://localhost:8080/api/managing/";

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) {
  }

  getAllManaging(brigadeId: number): Observable<Array<ManagingModel>>
  {
    return this.httpClient.get<Array<ManagingModel>>(this.url+'mg/'+ brigadeId)
  }

  deleteManaging(minerId: number){
    return this.httpClient.get(this.url+'delete/'+ minerId)
  }


  getAllMiners(): Observable<Array<MinerModel>>
  {
    return this.httpClient.get<Array<MinerModel>>(this.url+'miners/')
  }


  addBrigade(brigadeModel : BrigadeModel): Observable<BrigadeModel>{
    return this.httpClient.post<BrigadeModel>(this.url + 'add/', brigadeModel);
  }
}
