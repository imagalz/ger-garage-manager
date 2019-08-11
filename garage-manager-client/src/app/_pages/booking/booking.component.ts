import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService, CustomerService, AlertService } from 'src/app/_services';
import { VehicleService } from 'src/app/_services/vehicle.service';
import { ProfileService } from 'src/app/_services/profile.service';
import { first } from 'rxjs/operators';
import { BookingService } from 'src/app/_services/booking.service';
import { ServiceTypeService } from 'src/app/_services/service_type.service';
import { getLocaleDateFormat, DatePipe } from '@angular/common';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bookingForm: FormGroup;
  vehicles = [];
  serviceTypes = [];

  loading = false;
  submitted = false;
  customerProfile = true;

  viewMode = false;
  editMode = false;
  createMode = false;
  
  datePipe: DatePipe;
  

  constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
        private bookingService: BookingService,
        private vehicleService: VehicleService,
        private profileService: ProfileService,
        private serviceTypeService: ServiceTypeService,
        private alertService: AlertService,
  ) { 
    // redirect to home if already logged in
    if (this.authenticationService.currentUserValue) { 
        this.router.navigate(['/']);
        
        profileService.getById(this.authenticationService.currentUserValue.profile_id).subscribe(profile => {
            this.customerProfile = profile.id != 0;
        });
    }
  }

  ngOnInit() {

    this.bookingForm = this.formBuilder.group({
      customer: ['', Validators.required],
      bookedDate: [new Date().toLocaleDateString().toString()],
      estimatedCost: [''],
      estimatedDate: [''],
      status: [''],
      vehicle: ['', Validators.required],
      serviceType: ['', Validators.required],
      observation: [''],
      finishedDate: [''],
      reason: ['']
    });

    this.getVehicle().subscribe(result => {
      this.vehicles = result;
    });
    
    this.getServiceType().subscribe(result => {
      this.serviceTypes = result;
    });
  }

  getVehicle() {
      return this.vehicleService.getAll();
  }

  getServiceType() {
      return this.serviceTypeService.getAll();
  }

  get bControls() { 
    return this.bookingForm.controls; 
  }

  onSubmit() {
    let today: any = new Date();
    let dayOfWeek: number = today.getday(); 
    console.log(this.bookingForm.value);
    this.submitted = true;

    if (this.bookingForm.invalid) {
        return;
    }
    if (dayOfWeek != 7) {
      this.loading = true;
      this.bookingService.register(this.bookingForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.alertService.success('Booked successfully', true);
                  this.router.navigate(['/login']);
              },
              error => {
                  this.alertService.error(error);
                  this.loading = false;
              }); 
    } else {
      this.alertService.error('Unfortunally bookings on sundays are not allowed');
    }
  }

}
