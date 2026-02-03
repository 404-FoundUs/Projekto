package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.ChecklistModel;

import java.util.List;
import java.util.UUID;

public interface ChecklistStore {

    ChecklistModel save(UUID cardId, ChecklistModel checklistModel);
    ChecklistModel update(UUID cardId, ChecklistModel checklistModel);
    void delete(UUID id);
    void reorder(UUID cardId, List<UUID> orderedListIds);

}
