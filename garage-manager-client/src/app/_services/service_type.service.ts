import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking, Service, ServiceType } from '../_models';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { ApiConnection } from '../_guards/api.connection';

export class ServiceTypeService extends ApiConnection{
    
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common`;
    }

    getAll(): Observable<ServiceType[]> {
        const url = `${this.apiUrl}/serviceTypes/`;
        return this.http.get<ServiceType[]>(url)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<ServiceType> {
        const url = `${this.apiUrl}/serviceType/${id}`;

        return this.http.get<ServiceType>(url)
        .pipe(
            tap(_result => console.log('Good Return')),
            catchError(this.handleError<ServiceType>('getById'))
          );
    }
}