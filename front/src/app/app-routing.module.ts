import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { MagazineComponent } from './magazine/magazine.component';
import { ManagingComponent } from './managing/managing.component';
import {HomeComponent} from './home/home.component';
import {AuthComponent} from './auth/auth.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {AuthGuard} from './auth.guard';
import {MiningComponent} from './mining/mining.component';

const routes: Routes = [
  { path: '', component: HomeComponent, data: { animation: 'Home'} },
  { path: 'auth', component: AuthComponent, data: { animation: 'Auth'}, canActivate: [ AuthGuard ] },
  { path: 'profile', component: ProfileComponent, data: { animation: 'Profile' }, canActivate: [ AuthGuard ] },
  { path: 'schedule', component: ScheduleComponent, data: { animation: 'Schedule'}, canActivate: [ AuthGuard ] },
  { path: 'magazine', component: MagazineComponent, data: { animation: 'Magazine'}, canActivate: [ AuthGuard ] },
  { path: 'managing', component: ManagingComponent, data: { animation: 'Managing'}, canActivate: [ AuthGuard ] },
  { path: 'mining', component: MiningComponent, data: { animation: 'Mining'}, canActivate: [ AuthGuard ]},
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
