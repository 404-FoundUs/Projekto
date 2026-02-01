package com._FoundUs.Projekto.domain.usecase.Cards;

import com._FoundUs.Projekto.domain.repository.CardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReorderUsecase {
    private final CardStore cardStore;

    public void reorder(UUID listId, List<UUID> orderedCardIds){
        cardStore.reorder(listId, orderedCardIds);
    }
}
