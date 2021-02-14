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

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
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
export class ProfileComponent implements OnInit {

  items: MenuItem[];
  activeItem: MenuItem;

  profileMessages: Message[];
  minerMessages: MessageMinerModel[];

  miner: MinerModel;
  part: string;
  brigadeId: number;

  constructor(private primengConfig: PrimeNGConfig, private minerService: MinerService,
              private localStorageService: LocalStorageService, private titleService: Title,
              private messageMinerService: MessageMinerService) {
    this.titleService.setTitle('Profile');
  }

  ngOnInit(): void {

    this.minerService.getMiner(this.localStorageService.retrieve('minerId')).subscribe((minerData:MinerModel) => {
      this.miner = minerData;
      console.log(this.miner.minerId);
    });

    this.part = this.localStorageService.retrieve('part');
    this.brigadeId = this.localStorageService.retrieve('brigadeId');

    // TabMenu
    this.items = [
      {label: 'О себе', icon: 'pi pi-fw pi-user', badge: 'FFF',
        command: () => {
          this.activeItem = this.items[0];
          console.log(this.activeItem.label);
        }
      },
      {label: 'Дополнительная информация', icon: 'pi pi-fw pi-info',
        command: () => {
          this.activeItem = this.items[1];
          console.log(this.activeItem.label);
        }},
      {label: 'Сообщения', icon: 'pi pi-fw pi-envelope',
        command: () => {
          this.activeItem = this.items[2];
          console.log(this.activeItem.label);
        } }

    ];

    this.activeItem = this.items[0];
    this.profileMessages = [];


    this.messageMinerService.getMinerMessages(this.localStorageService.retrieve('minerId')).subscribe( messageMinerArray => {
      this.minerMessages = messageMinerArray;

      this.minerMessages.forEach(msg => {
        let profMsg = {
          severity: msg.status.toLowerCase(), summary: '', detail: msg.description,
          closable: false
        };
        this.profileMessages.push(profMsg);
      });
    });

    this.primengConfig.ripple = true;
  }

}

