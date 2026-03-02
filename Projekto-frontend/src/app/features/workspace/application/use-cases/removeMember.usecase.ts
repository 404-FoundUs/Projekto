import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class RemoveMemberUsecase {
  constructor(private repository: WorkspaceRepository) {}

  execute(workspaceId: UUID, userId: UUID) {
    return this.repository.removeMember(workspaceId, userId);
  }
}
