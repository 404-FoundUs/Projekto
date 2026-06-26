// models/user.entities.ts

// What the server expects when creating a user (signup)
export interface RequestUserDto {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  role?: string;  // Optional, might have default on backend
}

// What the server sends when signing in
export interface SigninRequestDto {
  email: string;
  password: string;
}

// What the server sends back after signup/signin/update
export interface ResponseUserDto {
  id: string;  // UUID from backend
  firstName: string;
  lastName: string;
  email: string;
  role: string;
  createdAt?: string;  // ISO date string
  updatedAt?: string;
}

// For displaying user info in the UI
export interface User {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  role: string;
  fullName?: string;  // Computed property for display
}
