/* eslint-disable @angular-eslint/prefer-inject */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { Injectable } from '@angular/core';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';
import { UUID } from 'crypto';
import { Observable } from 'rxjs';
import {
  CreateWorkspaceDto,
  WorkspaceDto,
  WorkspaceResponseDto,
} from '../../domain/entities/workspace.model';
import { environment } from '../../../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class WorkspaceService implements WorkspaceRepository {
  private baseUrl = environment.apiUrl + '/workspaces';

  constructor(private httpClient: HttpClient) {}

  create(model: CreateWorkspaceDto): Observable<WorkspaceDto> {
    return this.httpClient.post<WorkspaceDto>(this.baseUrl, { model });
  }
  addMemberToWorkspace(workspaceId: UUID, userId: UUID): Observable<WorkspaceDto> {
    return this.httpClient.post<WorkspaceDto>(this.baseUrl, { workspaceId, userId });
  }
  update(userId: UUID, model: CreateWorkspaceDto): Observable<WorkspaceDto> {
    return this.httpClient.put<WorkspaceDto>(this.baseUrl, { userId, model });
  }
  // double check this
  delete(userId: UUID): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl);
  }
  removeMemberFromWorkspace(workspaceId: UUID, userId: UUID): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl);
  }
  getWorkspaceById(workspaceId: UUID): Observable<WorkspaceResponseDto[]> {
    throw new Error('Method not implemented.');
  }
  getUserWorkspaces(userId: UUID): Observable<WorkspaceResponseDto[]> {
    return this.httpClient.get<WorkspaceResponseDto[]>(`${this.baseUrl}/user=${userId}`);
  }
}
