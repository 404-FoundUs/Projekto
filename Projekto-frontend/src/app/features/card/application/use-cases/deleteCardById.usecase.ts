import {CardRepository} from '../../domain/repositories/card.repository';

export class DeltaCardByIdUseCase {
  constructor(private readonly repository: CardRepository) {
  }

  execute(cardId: string) {
    return this.repository.deleteCardById(cardId);
  }
}
