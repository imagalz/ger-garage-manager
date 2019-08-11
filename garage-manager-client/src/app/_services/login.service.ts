import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models';
import { ApiConnection } from '../_guards/api.connection';
import { Observable, BehaviorSubject } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { AlertService } from './alert.service';


@Injectable({ providedIn: 'root' })
export class LoginService extends ApiConnection{
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient,
        private alertService: AlertService,) {
        super();
        this.apiUrl = `${this.apiUrl}/user/`

        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(login: string, password: string): Observable<User> {

        return this.http.post<User>(`${this.apiUrl}login/`, {"username": login, "password": password})
        .pipe(
            tap(result => {
                console.log('Good Return');

                localStorage.setItem('currentUser', JSON.stringify(result));
                this.currentUserSubject.next(result);
            },
            error => {
                this.alertService.error(error);
            }),
            catchError(this.handleError<User>('login'))
        );
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}