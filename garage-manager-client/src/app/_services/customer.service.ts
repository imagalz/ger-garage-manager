import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';


@Injectable({ providedIn: 'root' })
export class CustomerService  extends ApiConnection{
    constructor(private http: HttpClient) {
        super();
        this.apiUrl = `${this.apiUrl}/user/`
    }

    getAll(): Observable<User[]> {
        return this.http.get<User[]>(this.apiUrl)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError('getAll', []))
          );;
    }

    getById(id: number): Observable<User> {
        return this.http.get<User>(`${this.apiUrl}${id}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<User>('getById'))
          );
    }

    getByProfile(profileId: number): Observable<User[]> {
        return this.http.get<User[]>(`${this.apiUrl}profile/${profileId}`)
        .pipe(
            tap(result => console.log('Good Return')),
            catchError(this.handleError<User[]>('getByEmployeeId'))
          );
    }

    register(user: User): Observable<User> {        
        return this.http.post<User>(`${this.apiUrl}register`, user, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: User) => console.log(`add user w/ id=${result.id}`)),
            catchError(this.handleError<User>('addService'))
            );
    }

    update(user: User): Observable<User> {  
        return this.http.post<User>(`${this.apiUrl}update`, user, this.httpOptions).pipe(
            // tslint:disable-next-line:no-shadowed-variable
            tap((result: User) => console.log(`update user w/ id=${result.id}`)),
            catchError(this.handleError<User>('updateService'))
            );
    }
}