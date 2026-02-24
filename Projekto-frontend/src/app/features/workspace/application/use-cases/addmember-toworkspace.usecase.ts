import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class AddMemberToWorkspaceUsecase {
  constructor(private repository: WorkspaceRepository) {}
  excute(workspceId: UUID, userId: UUID) {
  return this.repository.addMemberToWorkspace(workspceId, userId);
  }
}
