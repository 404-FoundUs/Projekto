import { Component } from '@angular/core';
import { BoardCard } from "../../../shared/board-card/board-card";
import { SideNavigationbarBoard } from "../../../core/side-navigationbar-board/side-navigationbar-board";
import { BoardHeader } from "../../../core/board-header/board-header";

@Component({
  selector: 'app-boards-page',
  imports: [BoardCard, SideNavigationbarBoard, BoardHeader],
  templateUrl: './boards-page.html',
  styleUrl: './boards-page.scss',
})
export class BoardsPage {

}
