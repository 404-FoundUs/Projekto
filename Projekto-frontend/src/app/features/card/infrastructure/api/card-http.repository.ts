import {HttpClient} from '@angular/common/http';
import {CardRepository} from '../../domain/repositories/card.repository';
import {environment} from '../../../../../environments/environment.development';
import {Observable} from "rxjs";
import {CardResponseDto} from "../../domain/entities/card.model";

/*
*Todo: need testing to do !
* */
export class CardHttpRepository implements CardRepository {
  private baseUrl = environment.apiUrl + '/card';

  constructor(private httpClient: HttpClient) {
  }

  createCard(cardModel: CardResponseDto): Observable<CardResponseDto> {
    return this.httpClient.post<CardResponseDto>(this.baseUrl, cardModel);
  }

  getCardsByListId(listId: string): Observable<CardResponseDto[]> {
    return this.httpClient.get<CardResponseDto[]>(this.baseUrl + listId);
  }

  getCardById(cardId: string): Observable<CardResponseDto> {
    return this.httpClient.get<CardResponseDto>(this.baseUrl + cardId);
  }

  updateCard(cardId: string, card: CardResponseDto): Observable<CardResponseDto> {
    return this.httpClient.put<CardResponseDto>(this.baseUrl + cardId, card);
  }

  deleteCardById(cardId: string): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + cardId);
  }
}
