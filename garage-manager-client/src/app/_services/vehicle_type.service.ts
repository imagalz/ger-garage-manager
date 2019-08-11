import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking, Service, VehicleType } from '../_models';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { ApiConnection } from '../_guards/api.connection';

export class VehicleTypeService extends ApiConnection{
    
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common`;
    }

    getAll(): Observable<VehicleType[]> {
        const url = `${this.apiUrl}/vehicleTypes/`;
        return this.http.get<VehicleType[]>(url)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<VehicleType> {
        const url = `${this.apiUrl}/vehicleType/${id}`;

        return this.http.get<VehicleType>(url)
        .pipe(
            tap(_result => console.log('Good Return')),
            catchError(this.handleError<VehicleType>('getById'))
          );
    }
}