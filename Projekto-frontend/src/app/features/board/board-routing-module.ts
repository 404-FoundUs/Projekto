import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardsPage } from './pages/boards-page/boards-page';
import { KanbanBoardPage } from './pages/kanban-board-page/kanban-board-page';
import { CreateBoardCard } from './components/create-board-card/create-board-card';

const routes: Routes = [
  { path: '', component: BoardsPage },
  { path: 'board', component: BoardsPage },
  { path: 'create', component: CreateBoardCard },
  { path: 'kanban/:id', component: KanbanBoardPage },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BoardRoutingModule {}
