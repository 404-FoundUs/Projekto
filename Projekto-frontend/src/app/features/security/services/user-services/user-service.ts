import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';
import { Api } from '../../../../core/services/api';
import { User } from '../../models/users/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService extends Api {
  private endpoint = 'users';

  getAllUsers(): Observable<User[]> {
    return this.get<User[]>(this.endpoint);
  }

  getUserById(id: number): Observable<User> {
    return this.get<User>(`${this.endpoint}/${id}`);
  }

  // getUsersPaginated(page: number, size: number): Observable<PageResponse<User>> {
  //   const params = new HttpParams().set('page', page.toString()).set('size', size.toString());

  //   return this.get<PageResponse<User>>(this.endpoint, params);
  // }

  createUser(user: Partial<User>): Observable<User> {
    return this.post<User>(this.endpoint, user);
  }

  updateUser(id: number, user: Partial<User>): Observable<User> {
    return this.put<User>(`${this.endpoint}/${id}`, user);
  }

  deleteUser(id: number): Observable<void> {
    return this.delete<void>(`${this.endpoint}/${id}`);
  }

  searchUsers(query: string): Observable<User[]> {
    const params = new HttpParams().set('q', query);
    return this.get<User[]>(`${this.endpoint}/search`, params);
  }
}
