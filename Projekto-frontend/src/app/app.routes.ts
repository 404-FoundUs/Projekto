/* eslint-disable @typescript-eslint/no-unused-vars */
import { Routes } from '@angular/router';
import { LogInPage } from './features/security/pages/log-in-page/log-in-page';
import { RegisterPage } from './features/security/pages/register-page/register-page';
import { NotFoundPage } from './shared/pages/not-found-page/not-found-page';
import { HomePage } from './features/home/pages/home-page/home-page';
import { ForgotPasswordPage } from './features/security/pages/forgot-password-page/forgot-password-page';
import { WorkspacePage } from './features/workspace/pages/workspace-page/workspace-page';
import { ProfilePage } from './features/profile/pages/profile-page/profile-page';
import { UpdateProfilePage } from './features/profile/pages/update-profile-page/update-profile-page';
import { OtpVerificationPage } from './features/security/pages/otp-verification-page/otp-verification-page';
import { DashboardPage } from './features/dashboard/pages/dashboard-page/dashboard-page';
import { BoardsPage } from './features/workspace/pages/boards-page/boards-page';
import { KanbanBoardPage } from './features/workspace/pages/kanban-board-page/kanban-board-page';
import { CreateModelCard } from './features/workspace/components/create-model-card/create-model-card';
import { CreateBaordCard } from './features/workspace/components/create-baord-card/create-baord-card';
import { BoardSettingsPage } from './features/workspace/pages/board-settings-page/board-settings-page';
import { CreateWorkspaceCard } from './features/workspace/components/create-workspace-card/create-workspace-card';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomePage },
  { path: 'login', component: LogInPage },
  { path: 'register', component: RegisterPage },
  { path: 'forgot-password', component: ForgotPasswordPage },
  { path: 'profile', component: ProfilePage },
  { path: 'profile/edit', component: UpdateProfilePage },
  { path: 'otp-verification', component: OtpVerificationPage },
  { path: 'dashboard', component: DashboardPage },
  { path: 'workspaces', component: WorkspacePage },
  { path: 'workspaces/create-workspace', component: CreateWorkspaceCard },
  { path: 'workspaces/board/:id', component: BoardsPage },
  { path: 'workspaces/board/kanban', component: KanbanBoardPage },
  { path: 'workspaces/board/create-board', component: CreateBaordCard },
  { path: 'workspaces/board/kanban/create-model', component: CreateModelCard },
  { path: 'workspaces/board/settings', component: BoardSettingsPage },

  // not found page
  { path: '**', component: NotFoundPage },
];
