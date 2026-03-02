import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetByWorkspaceIdUsecase {
  constructor(private repository: WorkspaceRepository) {}

  execute(workspaceId: string) {
    return this.repository.getByWorkspaceId(workspaceId);
  }
}
