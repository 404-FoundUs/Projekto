export enum Visibility {
  PUBLIC = 'PUBLIC',
  PRIVATE = 'PRIVATE',
}
export interface WorkspaceDto {
  id: string;
  name: string;
  description: string;
  visibility: Visibility;
  ownerId: string;
  memberIds: string[];
  projectCount: number; // or whatever your backend returns
}

export interface CreateWorkspaceDto {
  name: string;
  description: string;
  visibility: Visibility;
  userId:string;
}

export interface WorkspaceResponseDto {
  id: string;
  name: string;
  description: string;
  visibility: Visibility;
  ownerId: string;
  memberIds: string[];
}