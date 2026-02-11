/* eslint-disable @typescript-eslint/no-unused-vars */
import {Routes} from '@angular/router';
import {LogInPage} from './features/auth/pages/log-in-page/log-in-page';
import {RegisterPage} from './features/auth/pages/register-page/register-page';
import {NotFoundPage} from './shared/pages/not-found-page/not-found-page';
import {HomePage} from './features/home/pages/home-page/home-page';
import {ForgotPasswordPage} from './features/auth/pages/forgot-password-page/forgot-password-page';
import {WorkspacePage} from './features/workspace/pages/workspace-page/workspace-page';
import {ProfilePage} from './features/profile/pages/profile-page/profile-page';
import {UpdateProfilePage} from './features/profile/pages/update-profile-page/update-profile-page';
import {OtpVerificationPage} from './features/auth/pages/otp-verification-page/otp-verification-page';
import {DashboardPage} from './features/dashboard/pages/dashboard-page/dashboard-page';
import {BoardsPage} from './features/board/pages/boards-page/boards-page';
import {KanbanBoardPage} from './features/board/pages/kanban-board-page/kanban-board-page';
import {CreateModelCard} from './features/board/components/create-model-card/create-model-card';
import {CreateBaordCard} from './features/board/components/create-baord-card/create-baord-card';
import {BoardSettingsPage} from './features/board/pages/board-settings-page/board-settings-page';
import {
  CreateWorkspaceCard
} from './features/workspace/components/workspaces/create-workspace-card/create-workspace-card';

export const routes: Routes = [
  // Root redirect
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },

  // Public routes
  {
    path: 'home',
    component: HomePage,
    title: 'Home'
  },

  // Auth routes
  {
    path: 'login',
    component: LogInPage,
    title: 'Login'
  },
  {
    path: 'register',
    component: RegisterPage,
    title: 'Register'
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordPage,
    title: 'Forgot Password'
  },
  {
    path: 'otp-verification',
    component: OtpVerificationPage,
    title: 'OTP Verification'
  },

  // Dashboard
  {
    path: 'dashboard',
    component: DashboardPage,
    title: 'Dashboard'
    // canActivate: [authGuard]  // Add auth guard if needed
  },

  // Profile routes
  {
    path: 'profile',
    component: ProfilePage,
    title: 'Profile'
  },
  {
    path: 'profile/edit',
    component: UpdateProfilePage,
    title: 'Edit Profile'
  },

  // ============================================================
  // WORKSPACE & BOARDS ROUTES (Properly Nested)
  // ============================================================
  {
    path: 'workspaces',
    children: [
      // List all workspaces
      {
        path: '',
        component: WorkspacePage,
        title: 'Workspaces'
      },

      // Create new workspace
      {
        path: 'create',
        component: CreateWorkspaceCard,
        title: 'Create Workspace'
      },

      // Workspace detail with boards
      {
        path: ':workspaceId',
        children: [
          // Redirect to boards by default
          {
            path: '',
            redirectTo: 'boards',
            pathMatch: 'full'
          },

          // Boards section
          {
            path: 'boards',
            children: [
              // List boards in workspace
              {
                path: '',
                component: BoardsPage,
                title: 'Boards'
              },

              // Create new board in workspace
              {
                path: 'create',
                component: CreateBaordCard,
                title: 'Create Board'
              },

              // Individual board routes
              {
                path: ':boardId',
                children: [
                  // Redirect to kanban by default
                  {
                    path: '',
                    redirectTo: 'kanban',
                    pathMatch: 'full'
                  },

                  // Kanban board view
                  {
                    path: 'kanban',
                    component: KanbanBoardPage,
                    title: 'Kanban Board'
                  },

                  // Create model/card in kanban
                  {
                    path: 'kanban/create-model',
                    component: CreateModelCard,
                    title: 'Create Card'
                  },

                  // Board settings
                  {
                    path: 'settings',
                    component: BoardSettingsPage,
                    title: 'Board Settings'
                  }
                ]
              }
            ]
          }
        ]
      }
    ]
  },

  // 404 Not Found (must be last!)
  {
    path: '**',
    component: NotFoundPage,
    title: 'Page Not Found'
  }
];
