/* eslint-disable @typescript-eslint/no-wrapper-object-types */
import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetUserWorkspacesUsecase {
  constructor(private repository: WorkspaceRepository) {}
  execute(userId: UUID) {
    return this.repository.getUserWorkspaces(userId);
  }
}
