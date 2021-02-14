import {Component, OnInit} from '@angular/core';
import { MenuItem, Message, MessageService } from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import {animate, sequence, style, transition, trigger} from '@angular/animations';
import {MinerModel} from '../model/miner.model';
import {MinerService} from '../service/miner.service';
import {LocalStorageService} from 'ngx-webstorage';
import { Title } from '@angular/platform-browser';
import {MessageMinerService} from '../service/message-miner.service';
import {MessageMinerModel} from '../model/message-miner.model';
import {MiningModel} from '../model/mining.model';
import {MiningService} from '../service/mining.service';

@Component({
  selector: 'app-mining',
  templateUrl: './mining.component.html',
  styleUrls: ['./mining.component.scss'],
  animations: [
    trigger('infoAnim', [
      transition('void => *', [
        style({ height: '*', opacity: '0', transform: 'translateX(-50px)', 'box-shadow': 'none' }),
        sequence([
          animate('0.2s ease', style({ height: '*', opacity: '.2', transform: 'translateX(0)', 'box-shadow': 'none'  })),
          animate('0.2s ease', style({ height: '*', opacity: 1, transform: 'translateX(0)' }))
        ])
      ])
    ])
  ]
})
export class MiningComponent implements OnInit {

  brigadeId: number;
  miningModel: MiningModel[];

  constructor(private localStorageService: LocalStorageService, private miningService: MiningService, private titleService: Title)
  {
    this.titleService.setTitle('Mining');
  }

  ngOnInit(): void {
    this.brigadeId = this.localStorageService.retrieve('brigadeId');
    this.miningService.getAllMinings(this.brigadeId).subscribe(miningArray => {
      this.miningModel = miningArray;
    });
  }

}

