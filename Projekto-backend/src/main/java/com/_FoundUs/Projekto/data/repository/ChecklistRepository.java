package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChecklistRepository extends JpaRepository<Checklist, UUID> {
}