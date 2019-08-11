import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Booking, Service, EngineType } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';


@Injectable({ providedIn: 'root' })
export class EngineTypeService  extends ApiConnection{
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/common/`;
    }

    getAll() : Observable<EngineType[]> {
        return this.http.get<EngineType[]>(`${this.apiUrl}engineTypes`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number) : Observable<EngineType> {
        return this.http.get<EngineType>(`${this.apiUrl}${id}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<EngineType>('getById'))
          );
    }
}