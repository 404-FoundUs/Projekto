import {Routes} from '@angular/router';
import {LogInPage} from './page/security/log-in-page/log-in-page';
import {RegisterPage} from './page/security/register-page/register-page';
import {NotFoundPage} from './core/not-found-page/not-found-page';
import {HomePage} from './page/home/home-page/home-page';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePage},
  {path: 'login', component: LogInPage},
  {path: 'register', component: RegisterPage},

  // not found page
  {path: '**', component: NotFoundPage},

];
