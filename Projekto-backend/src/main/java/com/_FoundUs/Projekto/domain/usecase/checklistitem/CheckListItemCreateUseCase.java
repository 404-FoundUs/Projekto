package com._FoundUs.Projekto.domain.usecase.checklistitem;


import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.domain.repository.CheckListItemStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListItemCreateUseCase {

    private final CheckListItemStore checkListItemStore;

    public ChecklistItemModel create(UUID checkListId, ChecklistItemModel checklistItemModel) {
        return checkListItemStore.create(checkListId, checklistItemModel);
    }

}
