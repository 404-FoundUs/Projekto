import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkspacePage } from './presentation/pages/pages/workspace-page/workspace-page';

const routes: Routes = [
  { path: '', redirectTo: '/workspaces'},
  { path: '/workspaces', component: WorkspacePage },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WorkspaceRoutingModule {}
