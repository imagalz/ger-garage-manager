import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User, Profile } from '../_models';
import { Observable } from 'rxjs';
import { ApiConnection } from '../_guards/api.connection';
import { tap, catchError } from 'rxjs/operators';


@Injectable({ providedIn: 'root' })
export class ProfileService extends ApiConnection{

    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/profile/`
    }

    getAll() : Observable<Profile[]> {
        return this.http.get<Profile[]>(this.apiUrl)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<Profile> {
        return this.http.get<Profile>(`${this.apiUrl}${id}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<Profile>('getById'))
          );
    }
}