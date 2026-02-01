package com._FoundUs.Projekto.domain.repository;


import com._FoundUs.Projekto.domain.model.ListModel;

import java.util.List;
import java.util.UUID;

public interface ListsStore {
    ListModel createList(ListModel listModel);
    List<ListModel> getListByBoard(UUID boardId);
    ListModel updateList(UUID id, ListModel listModel);
    void deleteList(UUID id);
    void reorderLists(UUID boardId, List<UUID> orderedListIds);
}
