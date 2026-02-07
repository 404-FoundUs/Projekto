import { Visibility } from "../enums/workspace.enum";

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
}