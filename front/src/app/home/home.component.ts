import {Component, OnDestroy, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  public constructor(private titleService: Title) {
    this.titleService.setTitle('Home');
  }

  time = new Date();
  timer;

  ngOnInit(): void {
    this.timer = setInterval(() => {
      this.time = new Date();
    }, 1000);
  }

  ngOnDestroy(): void {
    this.time = null;
    this.timer = null;
  }

  // tslint:disable-next-line:typedef
  // navigate() {
  //   if (this.authService.isAuthenticated()) {
  //     this.router.navigateByUrl('/main');
  //   } else {
  //     this.router.navigateByUrl('/auth');
  //   }
  // }

}


