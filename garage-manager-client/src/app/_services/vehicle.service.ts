import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VehicleMake, VehicleItem, Vehicle } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';


@Injectable({ providedIn: 'root' })
export class VehicleService extends ApiConnection{
    
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common`;
    }

    getAll(): Observable<Vehicle[]> {
        const url = `${this.apiUrl}/vehicles`;
        return this.http.get<Vehicle[]>(url)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<Vehicle> {
        const url = `${this.apiUrl}/vehicle/${id}`;

        return this.http.get<Vehicle>(url)
        .pipe(
            tap(_result => console.log('Good Return')),
            catchError(this.handleError<Vehicle>('getById'))
          );
    }
}