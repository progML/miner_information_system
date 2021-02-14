import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';
import { LoginComponent } from './auth/login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProfileComponent } from './profile/profile.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { MagazineComponent } from './magazine/magazine.component';
import { ManagingComponent } from './managing/managing.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenubarModule } from 'primeng/menubar';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {TabMenuModule} from 'primeng/tabmenu';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import { DialogModule } from 'primeng/dialog';
import { TableModule } from 'primeng/table';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HttpClientInterceptor } from './http-client-interceptor';
import { ToastModule } from 'primeng/toast';
import { MiningComponent } from './mining/mining.component';

FullCalendarModule.registerPlugins([
  dayGridPlugin,
  timeGridPlugin,
  interactionPlugin
])

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProfileComponent,
    HomeComponent,
    AuthComponent,
    LoginComponent,
    NotFoundComponent,
    ScheduleComponent,
    MagazineComponent,
    ManagingComponent,
    MiningComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenubarModule,
    NgbModule,
    InputTextModule,
    PasswordModule,
    ButtonModule,
    DropdownModule,
    FormsModule,
    ReactiveFormsModule,
    MatMenuModule,
    MatButtonModule,
    BrowserAnimationsModule,
    TabMenuModule,
    MessagesModule,
    MessageModule,
    FullCalendarModule,
    DialogModule,
    TableModule,
    NgxWebstorageModule.forRoot(),
    HttpClientModule,
    ToastModule
  ],
  providers: [ Title, { provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true } ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
