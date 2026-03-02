import { CreateWorkspaceDto } from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class CreateWorkspaceUseCase {
  constructor(private repository: WorkspaceRepository) {}

  // add validation
  execute(model: CreateWorkspaceDto) {
    return this.repository.create(model);
  }
}
