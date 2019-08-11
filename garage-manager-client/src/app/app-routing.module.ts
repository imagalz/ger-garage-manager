import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './_pages/home';
import { AuthGuard } from './_guards';
import { LoginComponent } from './_pages/login';
import { UserComponent } from './_pages/user';
import { CustomerListComponent } from './_pages/home/customer-list.component';
import { ServiceComponent } from './_pages/service-page/service.component';
import { BookingComponent } from './_pages/booking/booking.component';


const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  // { path: '', redirectTo: 'customer-list' },
  { path: 'login', component: LoginComponent },
  { path: 'user', component: UserComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'service', component: ServiceComponent },
  { path: 'customer-list', component: CustomerListComponent },

    // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes,{ onSameUrlNavigation: 'reload'})],
  providers: []
})
export class AppRoutingModule {

}
