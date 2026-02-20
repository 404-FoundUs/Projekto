import { UUID } from 'crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class DeleteWorkspaceUsecase {
  constructor(private repository: WorkspaceRepository) {}
  execute(userId: UUID) {
    this.repository.delete(userId);
  }
}
