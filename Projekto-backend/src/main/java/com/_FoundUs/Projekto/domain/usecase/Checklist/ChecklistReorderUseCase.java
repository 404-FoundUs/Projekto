package com._FoundUs.Projekto.domain.usecase.Checklist;

import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.repository.ChecklistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChecklistReorderUseCase {

    private final ChecklistStore checklistStore;

    public ChecklistModel reorder(UUID checklistId, ChecklistModel checklistModel) {
        return checklistStore.reorder(checklistId, checklistModel);
    }

}
