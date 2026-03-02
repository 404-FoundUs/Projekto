import { UUID } from 'node:crypto';
import { Observable } from 'rxjs';
import { CreateWorkspacePayload, Workspace } from '../entities/workspace.model';

export abstract class WorkspaceRepository {
  abstract create(model: CreateWorkspacePayload): Observable<CreateWorkspacePayload>;
  abstract addMember(workspaceId: UUID, userId: UUID): Observable<Workspace>;
  abstract update(userId: UUID, model: CreateWorkspacePayload): Observable<Workspace>;
  abstract delete(userId: UUID): Observable<void>;
  abstract removeMember(workspaceId: UUID, userId: UUID): Observable<void>;
  abstract getByWorkspaceId(workspaceId: string): Observable<Workspace[]>;
  abstract getByUserId(userId: string): Observable<Workspace[]>;
}
