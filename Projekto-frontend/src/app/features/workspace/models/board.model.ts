/**
 * Board model matching backend BoardResponseDto
 */
export interface Board {
  id: string;
  name: string;
  description?: string;
  visibility: 'PUBLIC' | 'PRIVATE' | 'WORKSPACE';
  workspaceId: string;
  
  // Creator information
  createdBy: string;
  createdByName?: string;
  createdByAvatar?: string;
  
  // Metadata
  createdAt: string | Date;
  updatedAt: string | Date;
  lastActiveAt?: string | Date;
  
  // UI Properties
  color: string;
  icon?: string;
  pinned: boolean;
  
  // Relationships
  lists?: string[];
  labels?: string[];
  
  // Statistics
  totalTasks?: number;
  completedTasks?: number;
  progress?: number;
  
  // Members
  members?: BoardMember[];
  memberCount?: number;
}

export interface BoardMember {
  id: string;
  name: string;
  email: string;
  avatarUrl: string;
  role: 'OWNER' | 'ADMIN' | 'MEMBER' | 'VIEWER';
}

/**
 * Create Board DTO matching backend BoardRequestDto
 */
export interface CreateBoardDto {
  name: string;
  description?: string;
  visibility: 'PUBLIC' | 'PRIVATE' | 'WORKSPACE';
  workspaceId: string;
  color?: string;
  icon?: string;
  pinned?: boolean;
  
  // ⚠️ DO NOT INCLUDE createdBy - it should come from backend auth token
  // createdBy will be set automatically by backend from JWT token
}

/**
 * Update Board DTO (partial updates)
 */
export interface UpdateBoardDto {
  name?: string;
  description?: string;
  visibility?: 'PUBLIC' | 'PRIVATE' | 'WORKSPACE';
  color?: string;
  icon?: string;
  pinned?: boolean;
}