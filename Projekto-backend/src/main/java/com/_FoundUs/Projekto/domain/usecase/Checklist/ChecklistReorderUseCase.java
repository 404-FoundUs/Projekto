package com._FoundUs.Projekto.domain.usecase.Checklist;

import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.repository.ChecklistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChecklistReorderUseCase {

    private final ChecklistStore checklistStore;

    public void reorder(UUID cardId, List<UUID> orderedListIds) {
        checklistStore.reorder(cardId, orderedListIds);
    }

}
