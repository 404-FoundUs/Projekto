import {Routes} from '@angular/router';
import {LogInPage} from './page/security/log-in-page/log-in-page';
import {RegisterPage} from './page/security/register-page/register-page';
import {NotFoundPage} from './core/not-found-page/not-found-page';
import {HomePage} from './page/home/home-page/home-page';
import { ForgotPasswordPage } from './page/security/forgot-password-page/forgot-password-page';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePage},
  {path: 'login', component: LogInPage},
  {path: 'register', component: RegisterPage},
  {path: 'forgot-password', component: ForgotPasswordPage},

  // not found page
  {path: '**', component: NotFoundPage},

];
