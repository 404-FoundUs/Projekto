/* eslint-disable @angular-eslint/prefer-inject */
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment.development';
import { CreateWorkspacePayload, Workspace } from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';
import { Observable } from 'rxjs';
import { UUID } from 'crypto';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class WorkspaceHttpRepository implements WorkspaceRepository {
  private baseUrl = environment.apiUrl + '/workspaces';

  constructor(private httpClient: HttpClient) {}

  create(model: CreateWorkspacePayload): Observable<CreateWorkspacePayload> {
    return this.httpClient.post<CreateWorkspacePayload>(this.baseUrl, model);
  }
  addMember(workspaceId: UUID, userId: UUID): Observable<Workspace> {
    return this.httpClient.post<Workspace>(this.baseUrl, { workspaceId, userId });
  }
  update(userId: UUID, model: CreateWorkspacePayload): Observable<Workspace> {
    return this.httpClient.put<Workspace>(this.baseUrl, { userId, model });
  }
  // double check this
  delete(userId: UUID): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + userId);
  }
  removeMember(workspaceId: UUID, userId: UUID): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + workspaceId + userId);
  }
  getByWorkspaceId(workspaceId: UUID): Observable<Workspace[]> {
    return this.httpClient.get<Workspace[]>(`${this.baseUrl}/${ workspaceId}`);
  }
  getByUserId(userId: string): Observable<Workspace[]> {
    return this.httpClient.get<Workspace[]>(`${this.baseUrl}/${userId}`);
  }
}
