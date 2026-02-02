package com._FoundUs.Projekto.domain.usecase.Cards;

import com._FoundUs.Projekto.domain.model.CardModel;
import com._FoundUs.Projekto.domain.repository.CardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCardUsecase {
    private final CardStore cardStore;

    public CardModel createCard(CardModel cardModel) {
        return cardStore.createCard(cardModel);
    }
}
