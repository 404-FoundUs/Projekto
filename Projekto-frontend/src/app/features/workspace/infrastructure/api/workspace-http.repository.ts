/* eslint-disable @angular-eslint/prefer-inject */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment.development';
import {
  CreateWorkspaceDto,
  WorkspaceDto,
  WorkspaceResponseDto,
} from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';
import { Observable } from 'rxjs';
import { UUID } from 'crypto';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class WorkspaceHttpRepository implements WorkspaceRepository {
  private baseUrl = environment.apiUrl + '/workspaces/';

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
    return this.httpClient.delete<void>(this.baseUrl + userId);
  }
  removeMemberFromWorkspace(workspaceId: UUID, userId: UUID): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + workspaceId + userId);
  }
  getWorkspaceById(workspaceId: UUID): Observable<WorkspaceDto[]> {
    return this.httpClient.get<WorkspaceDto[]>(this.baseUrl + workspaceId);
  }
  getUserWorkspaces(userId: string): Observable<WorkspaceDto[]> {
    return this.httpClient.get<WorkspaceDto[]>(this.baseUrl + userId);
  }
}
