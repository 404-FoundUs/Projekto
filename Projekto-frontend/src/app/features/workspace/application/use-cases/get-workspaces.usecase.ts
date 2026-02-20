import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetWorkspacesUseCase {
  constructor(private repository: WorkspaceRepository) {}

  execute() {
    this.repository.getAll();
  }
}
