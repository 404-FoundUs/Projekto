import { Injectable } from '@angular/core';
import { Api } from '../../../../core/services/api';
import { RequestUserDto, ResponseUserDto } from '../../model/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService extends Api {
  private endpoint = `users/`;

  // create workspace for user
  createWorkspace(dto: RequestUserDto): Observable<RequestUserDto> {
    return this.post<RequestUserDto>(this.endpoint, dto);
  }

  //update workspace for user
  updateWorkspace(p0: number, dto: RequestUserDto): Observable<RequestUserDto> {
    return this.put<RequestUserDto>(this.endpoint, dto);
  }

  // delete workspace from user
  deleteWorkspace(id: string): Observable<void> {
    return this.delete<void>(`${this.endpoint}/${id}`);
  }
  // get the workspace acording to the user
  getWorkspaces(userID: string): Observable<ResponseUserDto[]> {
    return this.get<ResponseUserDto[]>(this.endpoint + userID); // url error fixed with / concat
  }
}
