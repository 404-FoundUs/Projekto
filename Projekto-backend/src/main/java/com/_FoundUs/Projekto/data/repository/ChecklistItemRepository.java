package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Checklist;
import com._FoundUs.Projekto.data.entity.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, UUID> {

    List<ChecklistItem> findByChecklistIdOrderByPositionAsc(Checklist checklist);
    List<ChecklistItem> findByChecklistIdAndPositionGreaterThanEqualOrderByPositionAsc(UUID checkListItemId, Integer position);

}