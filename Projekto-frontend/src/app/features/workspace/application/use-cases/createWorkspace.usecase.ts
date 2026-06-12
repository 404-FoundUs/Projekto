import { CreateWorkspacePayload } from '../../domain/entities/workspace.model';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class CreateWorkspaceUseCase {
  constructor(private repository: WorkspaceRepository) {}

  // add validation
  execute(model: CreateWorkspacePayload) {
    return this.repository.create(model);
  }
}
