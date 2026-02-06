import { Component } from '@angular/core';
import { BoardCard } from "../../../shared/board-card/board-card";
import { SideNavigationbarBoard } from "../../../shared/side-navigationbar-board/side-navigationbar-board";
import { BoardHeader } from "../../../shared/board-header/board-header";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-boards-page',
  imports: [BoardCard, SideNavigationbarBoard, BoardHeader, RouterLink],
  templateUrl: './boards-page.html',
  styleUrl: './boards-page.scss',
})
export class BoardsPage {

}
