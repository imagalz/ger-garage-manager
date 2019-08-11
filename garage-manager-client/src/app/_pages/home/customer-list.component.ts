import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService, CustomerService, AlertService } from 'src/app/_services';
import { VehicleService } from 'src/app/_services/vehicle.service';
import { first } from 'rxjs/operators';
import { ProfileService } from 'src/app/_services/profile.service';
import { BookingService } from 'src/app/_services/booking.service';
import { ServiceService } from 'src/app/_services/service.service';
import { User } from 'src/app/_models';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html']
})
export class CustomerListComponent implements OnInit {
  currentUser: User;
  currentUserSubscription: Subscription;

  homeForm: FormGroup;

  adminProfile = false;
  customerProfile = false;
  employeeProfile = false;

  customerList  = [];
  employeeList  = [];
  
  customerTableColumns  :  string[] = ['name', 'mobile', 'situation', 'acao'];
  dsCustomer  = [];

  employeeTableColumns  :  string[] = ['name', 'mobile', 'situation', 'acao'];
  dsEmployee  = [];
  
  bookingTableColumns  :  string[] = ['booking', 'customer', 'bookedDate', 'status', 'acao'];
  dsBooking  = [];
  
  serviceTableColumns  :  string[] = ['service', 'employee', 'startDate', 'status', 'acao'];
  dsService  = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService,
    private userService: CustomerService,
    private vehicleService: VehicleService,
    private bookingService: BookingService,
    private serviceService: ServiceService,
    private profileService: ProfileService,
  ) { 
    this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
        this.currentUser = user;
    });
    
    // redirect to home if already logged in
    if (this.authenticationService.currentUserValue) { 
        this.router.navigate(['/']);
        
        profileService.getById(this.authenticationService.currentUserValue.profile_id).subscribe(profile => {
            
          this.adminProfile = profile.id == 0;
          this.customerProfile = profile.id == 1;
          this.employeeProfile = profile.id == 2;

        });
    }
  }

  ngOnInit() {

    this.homeForm = this.formBuilder.group({
      
    });

    this.getCustomers().subscribe(result => {
      this.dsCustomer = result;
    });
    
    this.getEmployees().subscribe(result => {
      this.dsEmployee = result;
    });
    
    if (this.adminProfile) {
      this.userService.getAll().subscribe(result=>{ 
        result.forEach(user => {
          if (user.profile_id == 1) {
            this.customerList.push(user);
          } else if (user.profile_id == 2) {
            this.employeeList.push(user);
          }
        })
      });

      this.bookingService.getAll().subscribe(result => {
        this.dsBooking = result;
      });
      
      this.serviceService.getAll().subscribe(result => {
        this.dsService = result;
      });
      
    };

    if (this.customerProfile) {
      this.bookingService.getByCustomer(this.authenticationService.currentUserValue.id).subscribe(result => {
        this.dsBooking = result;
      });
    }

    if (this.employeeProfile) {
      this.serviceService.getByEmployee(this.authenticationService.currentUserValue.id).subscribe(result => {
        this.dsService = result;
      });
    }

  }

  
  getEmployees() {
    return this.userService.getByProfile(3);
  }

  getAdmins() {
      return this.userService.getByProfile(1);
  }
  
  getCustomers() {
      return this.userService.getByProfile(2);
  }
  
  getRouting(type): string {
    let retorno = '/login';

    if (this.currentUser !== null && this.currentUser !== undefined) {
       retorno = '/' + retorno;
    }

    return retorno;
  }
}
