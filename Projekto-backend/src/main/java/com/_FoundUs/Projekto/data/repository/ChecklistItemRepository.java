package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, UUID> {
}