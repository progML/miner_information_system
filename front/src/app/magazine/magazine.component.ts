import {Component, Input, OnInit} from '@angular/core';
import {MagazineModel} from '../model/magazine.model';
import {MagazineService} from "../service/magazine.service";
import {LocalStorageService} from 'ngx-webstorage';
import {MenuItem, PrimeNGConfig} from "primeng/api";
import {AppComponent} from "../app.component";
import {FormControl, FormGroup} from "@angular/forms";
import {ManagingModel} from "../model/managing.model";
import {ManagingService} from "../service/managing.service";
import {RatingModel} from "../model/rating.model"
import {DatePipe} from "@angular/common";





@Component({
  selector: 'app-magazine',
  templateUrl: './magazine.component.html',
  styleUrls: ['./magazine.component.scss']
})
export class MagazineComponent implements OnInit {

  currentDate = new Date();

  pipe = new DatePipe('en-US');
  now = Date.now();
  myFormattedDate = this.pipe.transform(this.now, 'yyyy-MM-dd');

  managingModel: ManagingModel;
  managing: ManagingModel[]
  // magazineForm: FormGroup;
  mineName: string;
  inputValue: number;
  dateWork: String;
  magazineModel: MagazineModel;
  magazine: MagazineModel[]
  minerId: number;
  part: string;
  role: string;
  rating: number;
  brigadeId: number;
  ratingValue:FormControl = new FormControl()



  ratings: RatingModel[] = [
    {id: 1, rating: 1},
    {id: 2, rating: 2},
    {id: 3, rating: 3},
    {id: 4, rating: 4},
    {id: 5, rating: 5}
  ];



  public constructor(private managingService: ManagingService, private magazineService: MagazineService,
                     private localStorageService: LocalStorageService) {

    this.magazineModel ={
      mineName: '',
      minerId: 0,
      brigadeId: 0,
      part: '',
      dateWork: '',
      rating: 0,

    }
  }


  ngOnInit(){

      this.brigadeId = this.localStorageService.retrieve('brigadeId');

    this.magazineService.getAllBrigade(this.brigadeId).subscribe(magazineArray =>{
      this.managing = magazineArray;
      console.log(magazineArray)
    })
    //   this.magazineService.getAllBrigade(this.brigadeId).subscribe(magazineArray =>{
    //     this.managing = magazineArray;
    //     console.log(magazineArray)
    // })

      this.brigadeId = this.localStorageService.retrieve('brigadeId');
      this.part = this.localStorageService.retrieve('part');
      this.minerId = this.localStorageService.retrieve('minerId');
       if (this.part != 'БРИГАДИР') {
         this.magazineService.getAllMagazine(this.minerId).subscribe(magazineArray => {
           this.magazine = magazineArray;
           console.log(this.part);
         });
       }

      //


    // вывод всех шахтеров в одной бригаде (рабочий)
    // this.brigadeId = this.localStorageService.retrieve('brigadeId');
    // this.managingService.getAllManaging(this.brigadeId).subscribe(managingArray => {
    //   this.managing = managingArray;
    // })

  }


  addSubmit(minerId, part, date_work){


    this.mineName = 'Железорудная'; // Реализуем ли выбор шахт
    this.magazineModel.mineName = this.mineName;
    this.magazineModel.minerId = minerId;
    this.magazineModel.part = part;
    this.magazineModel.brigadeId = this.brigadeId;
    this.magazineModel.rating = this.ratingValue.value;
    this.magazineModel.dateWork = this.myFormattedDate; // todo: Вставлять дату

    console.log(this.magazineModel.dateWork)


    this.magazineService.addMagazine(this.magazineModel).subscribe( data => {
      this.magazine.push(data);
    });


  }

  onSubmit(){
    // this.dateWork = this.localStorageService.retrieve('date_work');
    this.minerId = this.inputValue
      this.magazineService.getAllMagazine(this.minerId).subscribe(magazineArray => {
        this.magazine = magazineArray;
        console.log(this.dateWork);
      });
  }
}
