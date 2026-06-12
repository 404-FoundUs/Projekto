import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class AddMemberUsecase {
  constructor(private repository: WorkspaceRepository) {}
  excute(workspceId: UUID, userId: UUID) {
  return this.repository.addMember(workspceId, userId);
  }
}
