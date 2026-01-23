package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Labels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LabelsRepository extends JpaRepository<Labels, UUID> {
}