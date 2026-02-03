package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.ChecklistItemModel;

import java.util.UUID;

public interface CheckListItemStore {
    ChecklistItemModel create(UUID checklistId, ChecklistItemModel checklistItemModel);
    ChecklistItemModel update(UUID listItemId, ChecklistItemModel checklistItemModel);
    void delete(UUID checklistItemId);
    ChecklistItemModel toggle(UUID checklistItemId);
}
