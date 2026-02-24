import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetWorkspaceById {
  constructor(private repository: WorkspaceRepository) {}

  execute(workspaceId: string) {
    return this.repository.getWorkspaceById(workspaceId);
  }
}
