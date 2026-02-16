import { ListResponsetDto } from './../models/list.model';
import { Injectable } from '@angular/core';
import { ListRequestDto } from '../models/list.model';
import { Observable } from 'rxjs';
import { Api } from '../../../core/services/api';

@Injectable({
  providedIn: 'root',
})
export class ListService extends Api {
  private createendpoint = 'boards';
  private endpoint = 'boards/workspace';
  // create
  createList(dto: ListRequestDto): Observable<ListRequestDto> {
    return this.post<ListRequestDto>(this.createendpoint, dto);
  }
  // update
  updateList(dto: ListRequestDto): Observable<ListRequestDto> {
    return this.put<ListRequestDto>(this.endpoint, dto);
  }

  // delete
  deleteList(boardid: string): Observable<void> {
    return this.delete<void>(`${this.endpoint}/${boardid}`);
  }

  // search by board id
  getList(boardid: string): Observable<ListResponsetDto[]> {
    return this.get<ListResponsetDto[]>(this.endpoint + boardid);
  }

  // search by workspace
  // getBoardByList(boardId: string): Observable<ListResponsetDto[]> {
  //   return this.get<ListResponsetDto[]>(this.endpoint + boardId);
  // }
}
