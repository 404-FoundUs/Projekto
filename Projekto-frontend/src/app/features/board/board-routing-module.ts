import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardsPage } from './pages/boards-page/boards-page';
import { CreateBaordCard } from './components/create-baord-card/create-baord-card';
import { KanbanBoardPage } from './pages/kanban-board-page/kanban-board-page';

const routes: Routes = [
  { path: '', component: BoardsPage },
  { path: 'board', component: BoardsPage },
  { path: 'create', component: CreateBaordCard },
  { path: 'kanban/:id', component: KanbanBoardPage },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BoardRoutingModule {}
