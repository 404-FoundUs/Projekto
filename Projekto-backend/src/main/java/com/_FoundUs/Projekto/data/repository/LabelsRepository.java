package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Labels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LabelsRepository extends JpaRepository<Labels, UUID> {
    List<Labels> findByBoard(Board board);
    boolean existsByBoardAndName(Board board, String name);
}