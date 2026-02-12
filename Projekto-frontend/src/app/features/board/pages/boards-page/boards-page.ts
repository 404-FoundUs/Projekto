/* eslint-disable @angular-eslint/prefer-inject */
import { BoardService } from './../../services/boards-service';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { SideNavigationbarBoard } from '../../components/side-navigationbar-board/side-navigationbar-board';
import { BoardHeader } from '../../components/board-header/board-header';
import { BoardCardComponent } from '../../components/board-card/board-card';
import { BoardResponseDto } from '../../models/board.model';

@Component({
  selector: 'app-boards-page',
  templateUrl: './boards-page.html',
  imports: [SideNavigationbarBoard, BoardHeader, RouterLink, BoardCardComponent],
})
export class BoardsPage implements OnInit {
  private userid = '1eb8083f-cda4-4c7b-9a11-74bdb4389765';
  private workspaceid = '5d2871fe-5984-4110-bd40-a337db158897';

  boards: BoardResponseDto[] = [];

  constructor(private boardService: BoardService) {}
  ngOnInit(): void {
    this.loadData();
  }

  // load data by workspace
  loadData() {
    this.boardService.getBoardByWorkspace(this.workspaceid).subscribe({
      next: (response) => {
        console.log('success', response);
      },
      error: (error) => {
        console.log('error', error);
      },
    });
  }
  // load data by boardid
  loadDataByBoard() {
    this.boardService.getBoard(this.workspaceid).subscribe({
      next: (response) => {
        console.log('success', response);
      },
      error: (error) => {
        console.log('error', error);
      },
    });
  }
}
