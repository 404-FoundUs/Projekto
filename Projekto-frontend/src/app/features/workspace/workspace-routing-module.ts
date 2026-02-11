import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkspacePage } from './pages/workspace-page/workspace-page';
import { CreateWorkspaceCard } from './components/workspaces/create-workspace-card/create-workspace-card';

const routes: Routes = [
  { path: '', component: WorkspacePage },
  { path: 'dashboard', component: WorkspacePage },
  { path: 'create', component: CreateWorkspaceCard },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WorkspaceRoutingModule {}
