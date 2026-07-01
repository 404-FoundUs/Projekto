import {CardRepository} from '../../domain/repositories/card.repository';
import {CardResponseDto} from '../../domain/entities/card.model';

export class createCardUseCase {
  constructor(private readonly repository: CardRepository) {
  }

  execute(cardRequest: CardResponseDto) {
    return this.repository.createCard(cardRequest);
  }
}
