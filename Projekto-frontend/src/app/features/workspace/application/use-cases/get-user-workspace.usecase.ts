import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetUserWorkspacesUsecase {
  constructor(private repository: WorkspaceRepository) {}
  execute(userId: UUID) {
    this.repository.getUserWorkspaces(userId);
  }
}
