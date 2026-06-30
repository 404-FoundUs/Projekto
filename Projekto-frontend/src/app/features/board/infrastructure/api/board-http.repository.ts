import {HttpClient} from '@angular/common/http';
import {BoardRepository} from '../../domain/repositories/board.repository';
import {environment} from '../../../../../environments/environment.development';
import {Observable} from "rxjs";
import {Board} from "../../../workspace/domain/entities/board.model";
import {BoardRequestDto} from "../../domain/entities/board.model";

export class BoardHttpRepository implements BoardRepository {
  private baseUrl = environment.apiUrl + '/board';

  constructor(private httpClient: HttpClient) {
  }

  createBoard(board: BoardRequestDto): Observable<Board> {
    return this.httpClient.post<Board>(this.baseUrl + '/board', board);
  }

  getBoardsByWorkspace(workspaceId: string): Observable<Board[]> {
    return this.httpClient.get<Board[]>(this.baseUrl + '/boards/' + workspaceId);
  }

  getBoardById(boardId: string): Observable<Board> {
    return this.httpClient.get<Board>(this.baseUrl + '/boards/' + boardId);
  }

  updateBoard(boardId: string, board: Board): Observable<Board> {
    return this.httpClient.put<Board>(this.baseUrl + '/boards/' + boardId, board);
  }

  deleteBoardById(boardId: string): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + '/boards/' + boardId);
  }

}
