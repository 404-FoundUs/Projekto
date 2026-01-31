import {Routes} from '@angular/router';
import {LogInPage} from './page/security/log-in-page/log-in-page';
import {RegisterPage} from './page/security/register-page/register-page';
import {NotFoundPage} from './core/not-found-page/not-found-page';
import {HomePage} from './page/home/home-page/home-page';
import { ForgotPasswordPage } from './page/security/forgot-password-page/forgot-password-page';
import { WorkspacePage } from './page/workspace/workspace-page/workspace-page';
import { ProfilePage } from './page/profile/profile-page/profile-page';
import { UpdateProfilePage } from './page/profile/update-profile-page/update-profile-page';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePage},
  {path: 'login', component: LogInPage},
  {path: 'register', component: RegisterPage},
  {path: 'forgot-password', component: ForgotPasswordPage},
  {path: 'workspaces', component: WorkspacePage},
  {path: 'profile', component: ProfilePage},
  {path: 'profile/edit', component: UpdateProfilePage},

  // not found page
  {path: '**', component: NotFoundPage},

];
