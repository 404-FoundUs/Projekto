import { UUID } from 'crypto';

export interface ListRequestDto {
  title: string;
  boardId: UUID;
}

export interface ReorderRequestDto {
  orderedListIds: UUID[];
}

export interface ListResponsetDto {
  id: UUID;
  title: string;
  possition: number;
  boardId: UUID;
}
