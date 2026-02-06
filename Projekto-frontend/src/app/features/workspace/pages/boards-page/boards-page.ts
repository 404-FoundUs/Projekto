import { Component } from '@angular/core';
import { BoardCard } from "../../components/board-card/board-card";
import { SideNavigationbarBoard } from "../../components/side-navigationbar-board/side-navigationbar-board";
import { BoardHeader } from "../../components/board-header/board-header";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-boards-page',
  imports: [BoardCard, SideNavigationbarBoard, BoardHeader, RouterLink],
  templateUrl: './boards-page.html',
  styleUrl: './boards-page.scss',
})
export class BoardsPage {

}
