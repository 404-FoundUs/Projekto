import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BoardRequestDto } from '../models/board.model';
import { Api } from '../../../core/services/api';
@Injectable({
  providedIn: 'root',
})
export class BoardService extends Api {
  // testing only for create
  // POST http://localhost:8080/api/v1/boards
  private createendpoint = 'boards';
  private endpoint = 'boards/workspace';
  // create
  createBoard(dto: BoardRequestDto): Observable<BoardRequestDto> {
    return this.post<BoardRequestDto>(this.createendpoint, dto);
  }
  // update
  updateBoard(dto: BoardRequestDto): Observable<BoardRequestDto> {
    return this.put<BoardRequestDto>(this.endpoint, dto);
  }

  // delete
  deleteBoard(boardid: string): Observable<BoardRequestDto> {
    return this.delete<BoardRequestDto>(`${this.endpoint}/${boardid}`);
  }

  // search by board id
  getBoard(boardid: string): Observable<BoardRequestDto[]> {
    return this.get<BoardRequestDto[]>(this.endpoint + boardid);
  }
  // search by workspace
  getBoardByWorkspace(workspaceid: string): Observable<BoardRequestDto[]> {
    return this.get<BoardRequestDto[]>(this.endpoint + workspaceid);
  }
}
