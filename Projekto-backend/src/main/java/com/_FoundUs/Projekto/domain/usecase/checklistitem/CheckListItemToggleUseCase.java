package com._FoundUs.Projekto.domain.usecase.checklistitem;

import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.domain.repository.CheckListItemStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListItemToggleUseCase {

    private final CheckListItemStore checkListItemStore;

    public ChecklistItemModel toggle(UUID listitemId) {
        return checkListItemStore.toggle(listitemId);
    }

}
