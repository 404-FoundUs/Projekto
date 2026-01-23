package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
}