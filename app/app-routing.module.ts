import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PreviewComponent } from './preview/preview.component';
import { FlightInfoComponent } from './flight-info/flight-info.component';
import { CategoryComponent } from './category/category.component';
import { TicketbookingComponent } from './ticketbooking/ticketbooking.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { PaymentComponent } from './payment/payment.component';
import { SearchedFlightComponent } from './searched-flight/searched-flight.component';
import { AuthGuard } from './auth.guard';
import { ProfileComponent } from './profile/profile.component';
import { OccupanyDetailsComponent } from './occupany-details/occupany-details.component';
import { AirportComponent } from './airport/airport.component';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { ContactUsComponent } from './contact-us/contact-us.component';

const routes: Routes = [
  { path:'', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegistrationComponent},
  { path: 'preview', component: PreviewComponent, canActivate : [AuthGuard] , data : {expectedRole : ['user']}},
  { path: 'flightInfo', component: FlightInfoComponent, canActivate : [AuthGuard] , data : {expectedRole : ['admin','user','exe']}},
  { path: 'category', component: CategoryComponent , canActivate : [AuthGuard] , data : {expectedRole : ['admin']}},
  { path: 'ticketbooking', component: TicketbookingComponent},
  { path: 'add-flight', component: AddFlightComponent , canActivate : [AuthGuard] , data : {expectedRole : ['admin']}},
  { path: 'payment', component: PaymentComponent},
  { path: 'searched-flight', component: SearchedFlightComponent, canActivate : [AuthGuard] , data : {expectedRole : ['admin','user','exe']}},
  { path : 'profile', component : ProfileComponent, canActivate : [AuthGuard] , data : {expectedRole : ['user']}},
  { path: 'occupany-details', component: OccupanyDetailsComponent, canActivate : [AuthGuard] , data : {expectedRole : ['exe']}},
  { path: 'airport', component: AirportComponent, canActivate : [AuthGuard] , data : {expectedRole : ['admin']}},
  { path: 'add-airport', component: AddAirportComponent, canActivate : [AuthGuard] , data : {expectedRole : ['admin']}},
  { path: 'contact-us', component: ContactUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
