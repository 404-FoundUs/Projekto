/* eslint-disable @angular-eslint/prefer-inject */
import {Observable} from "rxjs";
import {User} from "../../domain/entities/user.model";
import {AuthRepository} from '../../domain/repositories/Auth.repository';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../../../../../environments/environment.development';

@Injectable({providedIn: 'root'})
export class AuthHttpRepository implements AuthRepository {
  private baseUrl = environment.apiUrl + '/auth';

  constructor(private httpClient: HttpClient) {
  }

  signInWithEmailAndPassword(email: string, password: string): Observable<User> {
    return this.httpClient.post<User>(`${this.baseUrl}/${email}/signin`, password);
  }

  signUpUser(user: User): Observable<User> {
    return this.httpClient.post<User>(`${this.baseUrl}/${user}/signup`, user);
  }

  getByUserId(userId: string): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}/${userId}`);
  }
}
