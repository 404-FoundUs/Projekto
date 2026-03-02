/* eslint-disable @typescript-eslint/no-wrapper-object-types */
import { WorkspaceRepository } from '../../domain/repositories/workspace.repository';

export class GetByUserIdUsecase {
  constructor(private repository: WorkspaceRepository) {}
  execute(userId: string) {
    return this.repository.getByUserId(userId);
  }
}
