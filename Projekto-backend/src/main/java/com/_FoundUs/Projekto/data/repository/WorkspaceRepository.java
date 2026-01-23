package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
}