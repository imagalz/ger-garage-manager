import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatTableModule, MatCommonModule, MatNavList, MatListModule, MatCheckboxModule } from  '@angular/material';

import { AppComponent } from './app.component';

import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { LoginComponent } from './_pages/login';
import { HomeComponent } from './_pages/home';
import { AlertComponent } from './_components';
import { JwtInterceptor, ErrorInterceptor, fakeBackendProvider } from './_helpers';
import { CustomerListComponent } from './_pages/home/customer-list.component';
import { CommonModule } from '@angular/common';

import { NgSelectModule } from '@ng-select/ng-select';
import { BookingComponent } from './_pages/booking/booking.component';
import { ServiceComponent } from './_pages/service-page/service.component';
import { UserComponent } from './_pages/user';

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    BookingComponent,
    CustomerListComponent,
    ServiceComponent,
    UserComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    CommonModule,
    MatCommonModule,
    MatListModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    NgSelectModule
  ],
   
  providers: [  
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    fakeBackendProvider
  ],

  bootstrap: [ AppComponent ]
})

export class AppModule { }
