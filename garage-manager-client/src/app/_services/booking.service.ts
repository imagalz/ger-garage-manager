import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Booking } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
// import * as jsPDF from 'jspdf';
import 'jspdf-autotable';

declare let jsPDF: any;

@Injectable({ providedIn: 'root' })
export class BookingService extends ApiConnection{
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/booking/`
    }

    getAll(): Observable<Booking[]> {
        return this.http.get<Booking[]>(this.apiUrl)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<Booking> {
        return this.http.get<Booking>(`${this.apiUrl}${id}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<Booking>('getById'))
          );
    }

    getByCustomer(userId: number): Observable<Booking[]> {
        return this.http.get<Booking[]>(`${this.apiUrl}user/${userId}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<Booking[]>('getByEmployeeId'))
          );
    }

    register(booking: Booking): Observable<Booking> {        
        return this.http.post<Booking>(`${this.apiUrl}booking/register`, booking, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: Booking) => {
                let doc = new jsPDF();
                let columns = ["ID", "customer_id", "service_id", "vehicle_id", "booking_date", "estimated_date", "finished_date", "reason_ext_time", "observation"];
                let rows = [
                    [1, result.id, result.customer_id, result.service_id, result.vehicle_id, result.booking_date, result.estimated_date, result.finished_date, result.reason_ext_time, result.observation],
                ];
                doc.autoTable(columns, rows);
                doc.save('invoice.pdf');
                console.log(`add booking w/ id=${result.id}`);
            }),
            catchError(this.handleError<Booking>('addService'))
            );
    }

    update(booking: Booking): Observable<Booking> {  
        return this.http.post<Booking>(`${this.apiUrl}booking/update`, booking, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: Booking) => console.log(`update booking w/ id=${result.id}`)),
            catchError(this.handleError<Booking>('updateService'))
            );
    }
}