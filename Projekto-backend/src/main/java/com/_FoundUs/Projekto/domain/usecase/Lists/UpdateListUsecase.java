package com._FoundUs.Projekto.domain.usecase.Lists;

import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.domain.repository.ListsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateListUsecase {
    private final ListsStore listsStore;

    public ListModel updateList(UUID id, ListModel listModel) {
        return listsStore.updateList(id, listModel);
    }
}
