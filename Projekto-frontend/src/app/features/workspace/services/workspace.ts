/* eslint-disable @typescript-eslint/no-empty-function */
import { Injectable } from '@angular/core';
import { Api } from '../../../core/services/api';
import { Observable } from 'rxjs';
import { WorkspaceDto } from '../models/workspace.model';

@Injectable({
  providedIn: 'root',
})
export class Workspace extends Api {
  
  private endpoint = `workspaces/user/`;
  getAllWorkspacesByUser(userID: string): Observable<WorkspaceDto[]> {
    return this.get<WorkspaceDto[]>(this.endpoint+userID);
  }
}
