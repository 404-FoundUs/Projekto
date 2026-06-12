package com._FoundUs.Projekto.domain.usecase.Cards;

import com._FoundUs.Projekto.domain.model.CardModel;
import com._FoundUs.Projekto.domain.repository.CardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetCardByIdUsecase {
    private final CardStore cardStore;

    public CardModel getCardById(UUID cardId) {
        return cardStore.getCardById(cardId);
    }
}
