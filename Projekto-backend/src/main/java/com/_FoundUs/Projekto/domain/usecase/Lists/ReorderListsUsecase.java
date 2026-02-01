package com._FoundUs.Projekto.domain.usecase.Lists;

import com._FoundUs.Projekto.domain.repository.ListsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReorderListsUsecase {
    private final ListsStore listsStore;

    public void reorderLists(UUID boardId, List<UUID> orderedListIds) {
        listsStore.reorderLists(boardId, orderedListIds);
    }
}
