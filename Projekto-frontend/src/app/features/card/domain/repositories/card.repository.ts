import {Observable} from 'rxjs';
import {CardResponseDto} from '../entities/card.model';


/*
*Todo: need testing to do !
* */
export abstract class CardRepository {
  abstract createCard(cardModel: CardResponseDto): Observable<CardResponseDto>;

  abstract getCardsByListId(listId: string): Observable<CardResponseDto[]>;

  abstract getCardById(cardId: string): Observable<CardResponseDto>;

  abstract updateCard(cardId: string, card: CardResponseDto): Observable<CardResponseDto>;

  abstract deleteCardById(cardId: string): Observable<void>;

}
