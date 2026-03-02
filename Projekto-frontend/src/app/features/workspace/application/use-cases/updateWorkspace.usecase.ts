import { UUID } from 'crypto';
import { CreateWorkspacePayload } from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class UpdateWorkspaceUsecase {
  constructor(private repository: WorkspaceRepository) {}

  execute(userId: UUID, model: CreateWorkspacePayload) {
    return this.repository.update(userId, model);
  }
}
