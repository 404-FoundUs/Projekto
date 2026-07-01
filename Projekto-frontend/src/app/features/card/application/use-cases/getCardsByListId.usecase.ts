import {CardRepository} from '../../domain/repositories/card.repository';

export class GetCardsByListIdUseCase {
  constructor(private readonly repository: CardRepository) {
  }

  execute(cardId: string) {
    return this.repository.getCardsByListId(cardId);
  }
}
