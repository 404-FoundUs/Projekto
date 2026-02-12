export interface BoardRequestDto {
  name: string;
  description: string;
  visibility: string;
  workspaceId: string; // UUID represented as string
  createdBy: string; // UUID represented as string
}

export interface BoardResponseDto {
  id: string; // UUID represented as string
  name: string;
  description: string;
  visibility: string;
  workspaceId: string; // UUID represented as string
  createdBy: string; // UUID represented as string
  lists: string[]; // Array of UUIDs (represented as strings)
  labels: string[]; // Array of UUIDs (represented as strings)
}
