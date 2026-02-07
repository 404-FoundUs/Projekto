/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { Api } from '../../../core/services/api';
import { Observable } from 'rxjs';
import { CreateWorkspaceDto, WorkspaceDto, WorkspaceResponseDto } from '../models/workspace.model';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class Workspace extends Api {
  private endpoint = `workspaces/user/`;
  private endpointCreate = `workspaces/`;
  private readonly baseUrl = 'http://localhost:8080/api/v1/workspaces';

  getAllWorkspacesByUser(userID: string): Observable<WorkspaceDto[]> {
    return this.get<WorkspaceDto[]>(this.endpoint + userID);
  }

  // createWorkSpaceByUser(dto: CreateWorkspaceDto, userID: string): Observable<CreateWorkspaceDto> {
  //   const params = new HttpParams().set('ownerId', userID);
  //   return this.post<CreateWorkspaceDto>(this.endpointCreate, dto, { params });
  // }

  createWorkSpaceByUser(ownerId: string, dto: CreateWorkspaceDto): Observable<WorkspaceResponseDto> {
    const params = new HttpParams().set('ownerId', ownerId);
    return this.post<WorkspaceResponseDto>(this.baseUrl, dto, { params });
  }
}
