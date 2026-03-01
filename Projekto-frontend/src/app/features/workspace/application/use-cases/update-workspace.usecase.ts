import { UUID } from 'crypto';
import { CreateWorkspaceDto } from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class UpdateWorkspaceUsecase {
  constructor(private repository: WorkspaceRepository) {}

  execute(userId: UUID, model: CreateWorkspaceDto) {
    return this.repository.update(userId, model);
  }
}
