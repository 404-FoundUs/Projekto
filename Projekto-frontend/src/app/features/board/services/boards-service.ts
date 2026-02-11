/* eslint-disable @angular-eslint/prefer-inject */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { map, tap, catchError } from 'rxjs/operators';
import { environment } from '../../../../environments/environment.development';
import { Board, CreateBoardDto, UpdateBoardDto } from '../../workspace/models/board.model';

@Injectable({
  providedIn: 'root',
})
export class BoardService {
  // ✅ FIXED: Match backend endpoint structure
  private readonly API_URL = `${environment.apiUrl}/boards`;

  // State management
  private boardsSubject = new BehaviorSubject<Board[]>([]);
  public boards$ = this.boardsSubject.asObservable();

  constructor(private http: HttpClient) {}

  // ==================== CRUD OPERATIONS ====================

  /**
   * ✅ Get all boards by workspace ID
   * GET /api/v1/boards/workspace/{workspaceId}
   */
  getBoardsByWorkspace(workspaceId: string): Observable<Board[]> {
    return this.http.get<Board[]>(`${this.API_URL}/workspace/${workspaceId}`).pipe(
      map((boards) => this.convertDates(boards)),
      tap((boards) => {
        this.boardsSubject.next(boards);
      }),
      catchError((error) => {
        console.error('Error fetching boards:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Get single board by ID
   * GET /api/v1/boards/{boardId}
   */
  getBoard(boardId: string): Observable<Board> {
    return this.http.get<Board>(`${this.API_URL}/${boardId}`).pipe(
      map((board) => this.convertDate(board)),
      catchError((error) => {
        console.error('Error fetching board:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Create new board
   * POST /api/v1/boards
   *
   * ⚠️ IMPORTANT: Do NOT send createdBy - backend gets it from JWT token
   */
  createBoard(boardData: CreateBoardDto): Observable<Board> {
    // ✅ Remove createdBy if accidentally included
    const { ...cleanData } = boardData;

    return this.http.post<Board>(this.API_URL, cleanData).pipe(
      map((board) => this.convertDate(board)),
      tap((newBoard) => {
        const current = this.boardsSubject.value;
        this.boardsSubject.next([...current, newBoard]);
      }),
      catchError((error) => {
        console.error('Error creating board:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Update board (full update)
   * PUT /api/v1/boards/{boardId}
   */
  updateBoard(boardId: string, boardData: CreateBoardDto): Observable<Board> {
    return this.http.put<Board>(`${this.API_URL}/${boardId}`, boardData).pipe(
      map((board) => this.convertDate(board)),
      tap((updatedBoard) => {
        this.updateBoardInCache(updatedBoard);
      }),
      catchError((error) => {
        console.error('Error updating board:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Partial update board
   * PATCH /api/v1/boards/{boardId}
   */
  patchBoard(boardId: string, updates: UpdateBoardDto): Observable<Board> {
    return this.http.patch<Board>(`${this.API_URL}/${boardId}`, updates).pipe(
      map((board) => this.convertDate(board)),
      tap((updatedBoard) => {
        this.updateBoardInCache(updatedBoard);
      }),
      catchError((error) => {
        console.error('Error patching board:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Delete board
   * DELETE /api/v1/boards/{boardId}
   */
  deleteBoard(boardId: string): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${boardId}`).pipe(
      tap(() => {
        const current = this.boardsSubject.value;
        this.boardsSubject.next(current.filter((b) => b.id !== boardId));
      }),
      catchError((error) => {
        console.error('Error deleting board:', error);
        throw error;
      }),
    );
  }

  /**
   * ✅ Toggle board pin status
   * PATCH /api/v1/boards/{boardId}/pin
   */
  toggleBoardPin(boardId: string): Observable<Board> {
    return this.http.patch<Board>(`${this.API_URL}/${boardId}/pin`, {}).pipe(
      map((board) => this.convertDate(board)),
      tap((updatedBoard) => {
        this.updateBoardInCache(updatedBoard);
      }),
      catchError((error) => {
        console.error('Error toggling pin:', error);
        throw error;
      }),
    );
  }

  // ==================== HELPER METHODS ====================

  /**
   * Update board in local cache
   */
  private updateBoardInCache(updatedBoard: Board): void {
    const current = this.boardsSubject.value;
    const index = current.findIndex((b) => b.id === updatedBoard.id);

    if (index !== -1) {
      current[index] = updatedBoard;
      this.boardsSubject.next([...current]);
    }
  }

  /**
   * Convert date strings to Date objects
   */
  private convertDates(boards: Board[]): Board[] {
    return boards.map((board) => this.convertDate(board));
  }

  private convertDate(board: Board): Board {
    return {
      ...board,
      createdAt: new Date(board.createdAt),
      updatedAt: new Date(board.updatedAt),
      lastActiveAt: board.lastActiveAt ? new Date(board.lastActiveAt) : undefined,
    };
  }

  /**
   * Get cached boards
   */
  getCachedBoards(): Board[] {
    return this.boardsSubject.value;
  }

  /**
   * Clear cache
   */
  clearCache(): void {
    this.boardsSubject.next([]);
  }
}
