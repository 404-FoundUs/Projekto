import { BoardService } from './../../services/boards-service';
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { Board } from '../../../workspace/models/board.model';
import { SideNavigationbarBoard } from '../../components/side-navigationbar-board/side-navigationbar-board';
import { BoardHeader } from '../../components/board-header/board-header';
import { BoardCard } from '../../components/board-card/board-card';

@Component({
  selector: 'app-boards-page',
  templateUrl: './boards-page.html',
  imports: [SideNavigationbarBoard, BoardHeader, BoardCard, RouterLink],
})
export class BoardsPage implements OnInit, OnDestroy {
  toggleSortDropdown() {
    throw new Error('Method not implemented.');
  }
  getSortLabel() {
    throw new Error('Method not implemented.');
  }
  // setSortBy(arg0: unknown) {
  //   throw new Error('Method not implemented.');
  // }
  workspaceId = '';
  board: Board[] = [];
  loading = false;
  error: string | null = null;

  private destroy$ = new Subject<void>();
  viewMode: unknown;
  sortBy: unknown;

  constructor(
    private route: ActivatedRoute,
    private boardService: BoardService,
  ) {}

  ngOnInit(): void {
    // ✅ Get workspace ID from parent route
    this.route.parent?.paramMap.pipe(takeUntil(this.destroy$)).subscribe((params) => {
      this.workspaceId = params.get('workspaceId') || '';

      if (this.workspaceId) {
        this.loadBoards();
      } else {
        this.error = 'Invalid workspace ID';
      }
    });
  }

  /**
   * ✅ Load boards from backend
   */
  loadBoards(): void {
    this.loading = true;
    this.error = null;

    // ✅ FIXED: Call correct endpoint
    this.boardService
      .getBoardsByWorkspace(this.workspaceId)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (boards: Board[]) => {
          this.board = boards;
          this.loading = false;
        },
        error: (error: { status: number }) => {
          console.error('Error loading boards:', error);

          // ✅ Better error messages based on status code
          if (error.status === 404) {
            this.error = 'Workspace not found';
          } else if (error.status === 403) {
            this.error = 'You do not have permission to view these boards';
          } else if (error.status === 401) {
            this.error = 'Please login to view boards';
          } else {
            this.error = 'Failed to load boards. Please try again.';
          }

          this.loading = false;
        },
      });
  }

  /**
   * ✅ Toggle board pin
   */
  togglePin(board: Board, event: Event): void {
    event.stopPropagation();

    // ✅ FIXED: Call new pin endpoint
    this.boardService
      .toggleBoardPin(board.id)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (updatedBoard: Board) => {
          // Update local board
          const index = this.board.findIndex((b) => b.id === board.id);
          if (index !== -1) {
            this.board[index] = updatedBoard;
          }
        },
        error: (error: unknown) => {
          console.error('Error toggling pin:', error);
          // Show error to user (toast notification)
        },
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
