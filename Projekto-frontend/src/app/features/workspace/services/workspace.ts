/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { Api } from '../../../core/services/api';
import { Observable } from 'rxjs';
import { CreateWorkspaceDto, WorkspaceDto, WorkspaceResponseDto } from '../models/workspace.model';

@Injectable({
  providedIn: 'root',
})
export class Workspace extends Api {
  private endpoint = `workspaces/user/`;
  private endpointCreate = `workspaces/`;
  private readonly baseUrl = 'http://localhost:8080/api/v1/workspaces';

  // get the workspace acording to the user
  getWorkspaces(userID: string): Observable<WorkspaceDto[]> {
    return this.get<WorkspaceDto[]>(this.endpoint + userID);
  }

  // create workspace for user
  createWorkspace(dto: CreateWorkspaceDto): Observable<WorkspaceResponseDto> {
    return this.post<WorkspaceResponseDto>(this.baseUrl, dto);
  }

  //update workspace for user
  updateWorkspace(endpoint: string, dto: CreateWorkspaceDto): Observable<CreateWorkspaceDto> {
    return this.put<CreateWorkspaceDto>(endpoint, dto);
  }

  // delete workspace from user
  deleteWorkspace(endpoint: string, id: string): Observable<WorkspaceDto> {
    return this.delete<WorkspaceDto>(endpoint, id);
  }
}
