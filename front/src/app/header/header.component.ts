import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';
import {LocalStorageService} from 'ngx-webstorage';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{
  items: MenuItem[];
  minerId: number;
  username: string;
  part: string;

  constructor(private localStorageService: LocalStorageService, private authService: AuthService) {}

  ngOnInit(): void {
    this.minerId = this.localStorageService.retrieve('minerId');
    this.username = this.localStorageService.retrieve('username');
    this.part = this.localStorageService.retrieve('part');

    this.items = [
      {
        label: 'Расписание',
        routerLink: ['/schedule']
      },
      {
        label: 'Журнал',
        routerLink: ['/magazine']
      },
      {
        label: 'Добыча',
        routerLink: ['/mining']
      },
      {
        label: 'Управление',
        routerLink: ['/managing'],
        visible: this.part == 'БРИГАДИР'
      }
    ];
  }

  logout(): void {
    this.authService.logout();
  }
}
