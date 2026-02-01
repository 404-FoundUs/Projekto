import {Routes} from '@angular/router';
import {LogInPage} from './page/security/log-in-page/log-in-page';
import {RegisterPage} from './page/security/register-page/register-page';
import {NotFoundPage} from './core/not-found-page/not-found-page';
import {HomePage} from './page/home/home-page/home-page';
import { ForgotPasswordPage } from './page/security/forgot-password-page/forgot-password-page';
import { WorkspacePage } from './page/workspace/workspace-page/workspace-page';
import { ProfilePage } from './page/profile/profile-page/profile-page';
import { UpdateProfilePage } from './page/profile/update-profile-page/update-profile-page';
import { OtpVerificationPage } from './page/security/otp-verification-page/otp-verification-page';
import { DashboardPage } from './page/dashboard/dashboard-page/dashboard-page';
import { BoardsPage } from './page/workspace/boards-page/boards-page';
import { KanbanBoardPage } from './page/workspace/boards-page/kanban-board-page/kanban-board-page';
import { CreateModelCard } from './shared/create-model-card/create-model-card';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePage},
  {path: 'login', component: LogInPage},
  {path: 'register', component: RegisterPage},
  {path: 'forgot-password', component: ForgotPasswordPage},
  {path: 'profile', component: ProfilePage},
  {path: 'profile/edit', component: UpdateProfilePage},
  {path: 'otp-verification', component: OtpVerificationPage},
  {path: 'dashboard', component: DashboardPage},
  {path: 'workspaces', component: WorkspacePage},
  {path: 'workspaces/board', component: BoardsPage},
  {path: 'workspaces/board/kanban', component: KanbanBoardPage},
  // {path: 'workspaces/board/kanban/create-model', component: CreateModelCard},

  // not found page
  {path: '**', component: NotFoundPage},

];
