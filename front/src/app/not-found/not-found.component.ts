import { Component } from '@angular/core';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.scss', '../app.component.scss']
})
export class NotFoundComponent {

  public constructor(private titleService: Title ) {
    this.titleService.setTitle('404');
  }

}
