/* eslint-disable @angular-eslint/prefer-inject */
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { SideNavigationbarBoard } from '../../components/side-navigationbar-board/side-navigationbar-board';
import { BoardHeader } from '../../components/board-header/board-header';
import { BoardCardComponent } from "../../components/board-card/board-card";

@Component({
  selector: 'app-boards-page',
  templateUrl: './boards-page.html',
  imports: [SideNavigationbarBoard, BoardHeader, RouterLink, BoardCardComponent],
})
export class BoardsPage {

}
