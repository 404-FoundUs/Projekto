import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilePage } from './pages/profile-page/profile-page';
import { UpdateProfilePage } from './pages/update-profile-page/update-profile-page';

const routes: Routes = [
  { path: '', component: ProfilePage },
  { path: 'edit-profile', component: UpdateProfilePage },
  // { path: '', component: ProfilePage },
  // { path: '', component: ProfilePage },
  // { path: '', component: ProfilePage },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfileRoutingModule {}
