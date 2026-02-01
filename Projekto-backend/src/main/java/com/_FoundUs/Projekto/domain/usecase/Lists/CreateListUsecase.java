package com._FoundUs.Projekto.domain.usecase.Lists;

import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.domain.repository.ListsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateListUsecase {
    private final ListsStore listsStore;

    public ListModel createList(ListModel listModel) {
        return listsStore.createList(listModel);
    }
}
