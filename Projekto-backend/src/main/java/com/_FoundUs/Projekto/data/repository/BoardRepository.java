package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
    List<Board> findByWorkspaceId(Workspace workspace);
}