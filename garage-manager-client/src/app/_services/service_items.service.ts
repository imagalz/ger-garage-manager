import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking, Service, ServiceItems } from '../_models';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { ApiConnection } from '../_guards/api.connection';

export class ServiceItemsService extends ApiConnection{
    
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common`;
    }

    getAll(): Observable<ServiceItems[]> {
        const url = `${this.apiUrl}/serviceItems/`;
        return this.http.get<ServiceItems[]>(url)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<ServiceItems> {
        const url = `${this.apiUrl}/serviceItems/${id}`;

        return this.http.get<ServiceItems>(url)
        .pipe(
            tap(_result => console.log('Good Return')),
            catchError(this.handleError<ServiceItems>('getById'))
          );
    }
}