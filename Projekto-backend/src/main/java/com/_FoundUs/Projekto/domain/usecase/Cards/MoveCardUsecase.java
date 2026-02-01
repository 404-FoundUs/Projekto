package com._FoundUs.Projekto.domain.usecase.Cards;

import com._FoundUs.Projekto.domain.repository.CardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MoveCardUsecase {
    private final CardStore cardStore;

    public void moveCard(UUID cardId, UUID targetListId){
        cardStore.moveCard(cardId, targetListId);
    }
}
