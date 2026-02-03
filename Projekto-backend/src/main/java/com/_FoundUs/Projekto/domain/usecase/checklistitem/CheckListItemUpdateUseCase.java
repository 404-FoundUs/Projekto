package com._FoundUs.Projekto.domain.usecase.checklistitem;

import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.domain.repository.CheckListItemStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListItemUpdateUseCase {

    private final CheckListItemStore checkListItemStore;

    public ChecklistItemModel update(UUID listitemId, ChecklistItemModel checklistItemModel) {
        return checkListItemStore.update(listitemId,checklistItemModel);
    }

}
