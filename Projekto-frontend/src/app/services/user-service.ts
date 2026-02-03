import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private userUrl = "http://localhost:8080/api/v1/tests";
  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private http: HttpClient) {}

  sendTestData(data: unknown): Observable<unknown> {
    return this.http.post<unknown>(this.userUrl, data);
  }
}