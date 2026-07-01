import {UUID} from 'node:crypto';

/*
*Todo: need testing to do !
* */
export enum BoardVisibility {
  PRIVATE = 'PRIVATE',
  WORKSPACE = 'WORKSPACE',
  PUBLIC = 'PUBLIC'
}

export enum MemberRole {
  OWNER = 'OWNER',
  ADMIN = 'ADMIN',
  MEMBER = 'MEMBER',
  VIEWER = 'VIEWER'
}

export interface BoardMember {
  id: string;
  name: string;
  email: string;
  avatarUrl: string;
  role: MemberRole;
}

export interface BoardRequestDto {
  name: string;
  description: string;
  visibility: string;
  workspaceId: UUID;
  createdBy: UUID;
  color: string;
  icon: string;
  pinned: string;

}

export interface BoardResponseDto {
  id: string;
  name: string;
  description: string;
  visibility: BoardVisibility;

  workspaceId: string;

  createdBy: string;
  createdByName: string;
  createdByAvatar: string;

  lists: string[];
  labels: string[];

  createdAt: string;
  updatedAt: string;
  lastActiveAt: string;

  color: string;
  icon: string;
  pinned: boolean;

  totalTasks: number;
  completedTasks: number;
  progress: number;

  members: BoardMember[];
  memberCount: number;
}
