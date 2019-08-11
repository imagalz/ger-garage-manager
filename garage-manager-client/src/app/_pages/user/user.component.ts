import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService, CustomerService, AlertService } from 'src/app/_services';
import { VehicleService } from 'src/app/_services/vehicle.service';
import { first } from 'rxjs/operators';
import { ProfileService } from 'src/app/_services/profile.service';
import { VehicleMake, VehicleType, EngineType } from 'src/app/_models';
import { EngineTypeService } from 'src/app/_services/engine_type.service';
import { VehicleTypeService } from 'src/app/_services/vehicle_type.service';
import { VehicleMakeService } from 'src/app/_services/vehicle_make.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [CustomerService, VehicleMakeService, VehicleTypeService, EngineTypeService, ProfileService]
})
export class UserComponent implements OnInit {

    registerForm: FormGroup;
    makes = [];
    types = [];
    engines = [];

    loading = false;
    submitted = false;
    customerProfile = false;

    viewMode = false;
    editMode = false;
    createMode = false;
    
    tableColumns  :  string[] = ['license', 'make', 'type'];
    dataSource  = [];

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
        private userService: CustomerService,
        private vehicleMakeService: VehicleMakeService,
        private vehicleTypeService: VehicleTypeService,
        private engineService: EngineTypeService,
        private profileService: ProfileService,
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
        this.registerForm = this.formBuilder.group({
            first_name: ['', Validators.required],
            last_name: ['', Validators.required],
            email: ['', Validators.required],
            mobile_phone: ['', Validators.required],
            second_phone: [''],
            license: [''],
            password: ['', [Validators.required, Validators.minLength(6)]],
            vMakes: [''],
            vTypes: [''],
            vEngine: [''],
            customer: [false]
        });

        this.getVehicleTypes().subscribe((result)=>{    
            this.types =  result;
        })

        this.getVehicleMakes().subscribe((result)=>{    
            this.makes =  result;
        })

        this.getEngines().subscribe((result)=>{    
            this.engines =  result;
        })
        
    }

    getVehicleTypes() {
        return this.vehicleTypeService.getAll();
    }

    getVehicleMakes() {
        return this.vehicleMakeService.getAll();
    }

    getEngines() {
        return this.engineService.getAll();
    }

    // convenience getter for easy access to form fields
    get rControls() { 
        return this.registerForm.controls; 
    }

    onSubmit() {
        this.submitted = true;
        console.log("jjs");
        if (this.registerForm.invalid) {
            console.log(this.registerForm)
            return;
        }

        this.loading = true;
        console.log(this.registerForm.value)
        this.userService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    console.log('Registration successful');

                    const routerPage = this.customerProfile ? '/login' : 'customer-list';

                    this.router.navigate([routerPage]);
                },
                error => {
                    this.alertService.error(error);
                    console.log('error');
                    this.loading = false;
                });

    }

    changeProfile() {
        this.customerProfile = !this.customerProfile;
        
        console.log(this.customerProfile);
    }

}
