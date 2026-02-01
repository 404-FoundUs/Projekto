package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Lists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ListsRepository extends JpaRepository<Lists, UUID> {
    List<Lists> findByBoardOrderByPositionAsc(Board board);
}