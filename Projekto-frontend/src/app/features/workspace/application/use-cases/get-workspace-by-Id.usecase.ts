import { UUID } from 'node:crypto';
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetWorkspaceById {
  constructor(private repository: WorkspaceRepository) {}

  execute(workspaceId: UUID) {
    this.repository.getWorkspaceById(workspaceId);
  }
}
