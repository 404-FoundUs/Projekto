/* eslint-disable @typescript-eslint/no-unused-vars */
import { Injectable } from '@angular/core';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class Api {
  protected apiUrl = environment.apiUrl;

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private httpClient: HttpClient) {}

  protected get<T>(endpoint: string, params?: HttpParams): Observable<T> {
    return this.httpClient.get<T>(`${this.apiUrl}/${endpoint}`, { params });
  }

  protected post<T>(endpoint: string, body: unknown): Observable<T> {
    return this.httpClient.post<T>(`${this.apiUrl}/${endpoint}`, body);
  }

  protected put<T>(endpoint: string, body: unknown): Observable<T> {
    return this.httpClient.put<T>(`${this.apiUrl}/${endpoint}`, body);
  }

  protected delete<T>(endpoint: string, workspaceId: string): Observable<T> {
    return this.httpClient.delete<T>(`${this.apiUrl}/${endpoint}`);
  }

  protected patch<T>(endpoint: string, body: unknown): Observable<T> {
    return this.httpClient.patch<T>(`${this.apiUrl}/${endpoint}`, { body });
  }
}
