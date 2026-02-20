import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class CreateWorkspaceUseCase {
  constructor(private workspaceRepository: WorkspaceRepository) {}

  execute(name: string) {
    if (!name.trim()) {
      throw new Error('name required');
    }
    return this.workspaceRepository.create(name);
  }
}
