package com._FoundUs.Projekto.domain.usecase.checklistitem;

import com._FoundUs.Projekto.domain.repository.CheckListItemStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListItemDeleteUseCase {

    private final CheckListItemStore checkListItemStore;

    public void delete(UUID listitemId) {
        checkListItemStore.delete(listitemId);
    }

}
