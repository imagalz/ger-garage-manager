import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Booking, Service } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { tap, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Injectable({ providedIn: 'root' })
export class ServiceService extends ApiConnection{
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/service/`
    }

    getAll(): Observable<Service[]> {
        return this.http.get<Service[]>(this.apiUrl)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<Service> {
        return this.http.get<Service>(`${this.apiUrl}/${id}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<Service>('getById'))
          );
    }

    getByEmployee(employeeId: number): Observable<Service[]> {
        return this.http.get<Service[]>(`${this.apiUrl}employee/${employeeId}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<Service[]>('getByEmployeeId'))
          );
    }

    register(service: Service): Observable<Service> {        
        return this.http.post<Service>(`${this.apiUrl}services/register`, service, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: Service) => console.log(`add service w/ id=${result.id}`)),
            catchError(this.handleError<Service>('addService'))
            );
    }

    update(service: Service): Observable<Service> {  
        return this.http.post<Service>(`${this.apiUrl}services/update`, service, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: Service) => console.log(`update service w/ id=${result.id}`)),
            catchError(this.handleError<Service>('updateService'))
            );
    }
}