package com._FoundUs.Projekto.domain.usecase.Lables;

import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RemoveFromCardUsecase {
    private final LablesStore lablesStore;

    public void removeFromCard(UUID cardId, UUID labelId) {
        lablesStore.removeFromCard(cardId, labelId);
    }
}
