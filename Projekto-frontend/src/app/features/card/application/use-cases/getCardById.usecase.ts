import {CardRepository} from '../../domain/repositories/card.repository';

export class GetCardByIdUseCase {
  constructor(private readonly repository: CardRepository) {
  }

  execute(cardId: string) {
    return this.repository.getCardById(cardId);
  }
}
