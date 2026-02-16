export enum Priority {
  LOW,
  MEDIUM,
  HIGH,
}

export interface CardRequestDto {
  title: string;
  description: string;
  dueDate: string; // LocalDateTime -> ISO string
  priority: Priority;
  listId: string; // UUID -> string
}

export interface CardResponseDto {
  id: string; // UUID -> string
  title: string;
  description: string;
  position: number; // Integer -> number
  dueDate: string; // LocalDateTime -> ISO string
  priority: Priority;
  listId: string; // UUID -> string
}
