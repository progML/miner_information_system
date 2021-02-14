import {Component, OnInit} from '@angular/core';
import {LocalStorageService} from 'ngx-webstorage';
import {ManagingModel} from "../model/managing.model";
import {ManagingService} from "../service/managing.service";
import {MinerModel} from "../model/miner.model";
import {FormControl} from "@angular/forms";
import {RatingModel} from "../model/rating.model";
import {PartModel} from "../model/part.model";
import {BrigadeModel} from "../model/brigade.model";


@Component({
  selector: 'app-managing',
  templateUrl: './managing.component.html',
  styleUrls: ['./managing.component.scss']
})
export class ManagingComponent implements OnInit {
  brigadeModel: BrigadeModel;
  brigade: BrigadeModel[];

  minerModel: MinerModel;
  miners: MinerModel[]
  part: String;
  managingModel: ManagingModel;
  managing: ManagingModel[]
  minerId: number;
  managingValue: number;
  brigadeId: number;
  partValues:FormControl = new FormControl()


  parts: PartModel[] = [
    {id:"БУРИЛЬЩИК", part: "БУРИЛЬЩИК"},
    {id:"ВОДИТЕЛЬ", part: "ВОДИТЕЛЬ"},
    {id:"КОПАТЕЛЬ", part: "КОПАТЕЛЬ"}
  ];


  public constructor(private managingService: ManagingService
    , private localStorageService: LocalStorageService) {

    this.brigadeModel = {
      brigadeId: 0,
      minerId: 0,
      part:' '
    }

  }

  ngOnInit() {
    this.managingService.getAllMiners().subscribe(minerArray => {
      this.miners = minerArray;
    });

    this.brigadeId = this.localStorageService.retrieve('brigadeId');
    this.managingService.getAllManaging(this.brigadeId).subscribe(managingArray => {
      this.managing = managingArray;
    })
  }


  addSubmit(minerId){

    this.brigadeModel.brigadeId = this.brigadeId;
    this.brigadeModel.minerId = minerId;
    this.brigadeModel.part = this.partValues.value;

    console.log(minerId)
    this.managingService.addBrigade(this.brigadeModel).subscribe( data => {
      this.brigade.push(data)
    })
  }

  deleteSubmit(mg) {
    this.minerId = mg;
    console.log(this.minerId)
    this.managingService.deleteManaging(this.minerId).subscribe(data => {
    });
  }
}

