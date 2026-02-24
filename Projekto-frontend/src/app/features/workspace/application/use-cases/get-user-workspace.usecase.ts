/* eslint-disable @typescript-eslint/no-wrapper-object-types */
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetUserWorkspacesUsecase {
  constructor(private repository: WorkspaceRepository) {}
  execute(userId: string) {
    return this.repository.getUserWorkspaces(userId);
  }
}
