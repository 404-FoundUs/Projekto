import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class RemoveMemberFromWorkspaceUsecase {
  constructor(private repository: WorkspaceRepository) {}

  execute(workspaceId: UUID, userId: UUID) {
    return this.repository.removeMemberFromWorkspace(workspaceId, userId);
  }
}
