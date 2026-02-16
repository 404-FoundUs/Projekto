/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { Api } from '../../../core/services/api';
import { Observable } from 'rxjs';
import {
  CreateWorkspaceDto,
  WorkspaceDto,
  WorkspaceResponseDto,
  WorkspaceUpdateDto,
} from '../models/workspace.model';

@Injectable({
  providedIn: 'root',
})
export class Workspace extends Api {
  // change if somethig breaks as 'workspaces/'
  private endpoint = `workspaces/`;

  // create workspace for user
  createWorkspace(dto: CreateWorkspaceDto): Observable<WorkspaceResponseDto> {
    return this.post<WorkspaceResponseDto>(this.endpoint, dto);
  }

  //update workspace for user
  updateWorkspace(p0: number, dto: WorkspaceUpdateDto): Observable<WorkspaceUpdateDto> {
    return this.put<WorkspaceUpdateDto>(this.endpoint, dto);
  }

  // delete workspace from user
  deleteWorkspace(id: string): Observable<void> {
    return this.delete<void>(`${this.endpoint}/${id}`);
  }
  // get the workspace acording to the user
  getWorkspaces(userID: string): Observable<WorkspaceDto[]> {
    return this.get<WorkspaceDto[]>(this.endpoint + userID); // url error fixed with / concat
  }

  // get the workspace by id
  getWorkspacesById(workspaceid: string): Observable<WorkspaceResponseDto[]> {
    return this.get<WorkspaceResponseDto[]>(this.endpoint + workspaceid); // url error fixed with / concat
  }
}
