import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking, Service, VehicleMake } from '../_models';
import { tap, catchError } from 'rxjs/operators';
import { ApiConnection } from '../_guards/api.connection';
import { Observable } from 'rxjs';


export class VehicleMakeService extends ApiConnection{
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common`;
    }

    getAll(): Observable<VehicleMake[]> {
        const url = `${this.apiUrl}/vehicleMakes/`;
        return this.http.get<VehicleMake[]>(url)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<VehicleMake> {
        const url = `${this.apiUrl}/vehicleMake/${id}`;

        return this.http.get<VehicleMake>(url)
        .pipe(
            tap(_result => console.log('Good Return')),
            catchError(this.handleError<VehicleMake>('getById'))
          );
    }
}