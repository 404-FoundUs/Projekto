import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkspacePage } from './presentation/pages/pages/workspace-page/workspace-page';
import { CreateWorkspaceCard } from './presentation/components/create-workspace-card/create-workspace-card';

const routes: Routes = [
  { path: '', component: WorkspacePage },
  // TODO: update the route name
  { path: 'create', component: CreateWorkspaceCard },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WorkspaceRoutingModule {}
