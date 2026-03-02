import { UUID } from 'node:crypto';

export enum Visibility {
  PUBLIC = 'PUBLIC',
  PRIVATE = 'PRIVATE',
}
export interface Workspace {
  id: string;
  name: string;
  description: string;
  visibility: Visibility;
  ownerId: string;
  memberIds: string[];
}
export interface CreateWorkspacePayload {
  name: string;
  description: string;
  visibility: Visibility;
  ownerId: UUID;
}

// export interface Workspace extends Workspace{
//   projectCount: number;
// }


