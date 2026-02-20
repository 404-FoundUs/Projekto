import { UUID } from 'node:crypto';
import { Observable } from 'rxjs';
import {
  CreateWorkspaceDto,
  WorkspaceDto,
  WorkspaceResponseDto,
} from '../entities/workspace.model';

export abstract class WorkspaceRepository {
  abstract create(model: CreateWorkspaceDto): Observable<WorkspaceDto>;
  abstract update(userId: UUID, model: CreateWorkspaceDto): Observable<WorkspaceDto>;
  abstract delete(userId: UUID): Observable<void>;
  abstract getWorkspaceById(workspaceId: UUID): Observable<WorkspaceResponseDto[]>;
  abstract getUserWorkspaces(userId: UUID): Observable<WorkspaceResponseDto[]>;
}
