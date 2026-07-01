import { UUID } from 'node:crypto';

/*
*Todo: need testing to do !
* */
export enum Priority {
  LOW = 'LOW',
  MEDIUM = 'MEDIUM',
  HIGH = 'HIGH'
}

export interface CardResponseDto {
  id: UUID;

  title: string;
  description: string;

  position: number;
  dueDate: string;

  priority: Priority;

  listId: UUID;
}

export interface MoveCardRequestDto {
  targetListId: UUID;
  newPosition: number;
}

export interface CardRequestDto {
  title: string;
  description: string;

  dueDate: string;

  priority: Priority;

  listId: UUID;
}

export interface ReorderCardsRequestDto {
  orderedCardIds: UUID[];
}
