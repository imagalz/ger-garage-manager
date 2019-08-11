import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { ServiceItemsService } from 'src/app/_services/service_items.service';
import { ServiceTypeService } from 'src/app/_services/service_type.service';
import { CustomerService } from 'src/app/_services/customer.service';
import { ProfileService } from 'src/app/_services/profile.service';
import { AuthenticationService, AlertService } from 'src/app/_services';
import { VehicleService } from 'src/app/_services/vehicle.service';
import { ServiceService } from 'src/app/_services/service.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {

  serviceForm: FormGroup;
  employees = [];
  serviceTypes = [];
  items = [];
  status = [];

  loading = false;
  submitted = false;
  customerProfile = true;

  viewMode = false;
  editMode = false;
  createMode = false;
  
  tableColumns  :  string[] = ['item', 'cost'];
  dataSource  = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService,
    private serviceService: ServiceService,
    private vehicleService: VehicleService,
    private profileService: ProfileService,
    private userService: CustomerService,
    private serviceTypeService: ServiceTypeService,
    private serviceItemsService: ServiceItemsService,
    private alertService: AlertService,
  ) { 
    // redirect to home if already logged in
    if (this.authenticationService.currentUserValue) { 
        this.router.navigate(['/']);
        
        profileService.getById(this.authenticationService.currentUserValue.profile_id).subscribe(profile => {
            this.customerProfile = profile.id == 1;
        });
    }
  }

  ngOnInit() {
    this.serviceForm = this.formBuilder.group({
        booking: [''],
        bookedDate: [''],
        estimatedDate: [''],
        vehicle: [''],
        observation: [''],
        finishedDate: [''],
        reason: [''],
        startedDate: [new Date().toLocaleDateString().toString(), Validators.required],
        items: ['', Validators.required],
        serviceType: ['', Validators.required],
        status: ['', Validators.required],
        employees: ['', Validators.required],
        cost: ['', Validators.required]
    });

    this.getEmployees().subscribe(result => {
      this.employees = result;
    });

    this.getServiceTypes().subscribe(result => {
      this.serviceTypes = result;
    });
    
    this.getItems().subscribe(result => {
      this.items = result;
    });

    this.status = this.getStatusService();
  }

  getStatusService() {
    return [
      { id: '1', name: 'Booked' },
      { id: '2', name: 'In Service'  },
      { id: '3', name: 'Fixed / Completed'  },
      { id: '4', name: 'Collected'  },
      { id: '4', name: 'Unrepairable / Scrapped'  }
    ];
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

  getServiceTypes() {
    return this.serviceTypeService.getAll();
  }

  getItems() {
    return this.serviceItemsService.getAll();
  }

  // convenience getter for easy access to form fields
  get sControls() { 
      return this.serviceForm.controls; 
  }

  onSubmit() {
      console.log(this.serviceForm.value);
      this.submitted = true;

      // stop here if form is invalid
      if (this.serviceForm.invalid) {
          return;
      }

      this.loading = true;
      this.serviceService.register(this.serviceForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.alertService.success('Registration successful', true);
                  this.router.navigate(['/login']);
              },
              error => {
                  this.alertService.error(error);
                  this.loading = false;
              });
  }

}
