import {Observable} from 'rxjs';
import {Board} from '../../../workspace/domain/entities/board.model';
import {BoardRequestDto} from '../entities/board.model';

export abstract class BoardRepository {
  abstract createBoard(board: BoardRequestDto): Observable<Board>;

  abstract getBoardsByWorkspace(workspaceId: string): Observable<Board[]>;

  abstract getBoardById(boardId: string): Observable<Board>;

  abstract updateBoard(boardId: string, board: Board): Observable<Board>;

  abstract deleteBoardById(boardId: string): Observable<void>;
}
