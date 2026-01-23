package com._FoundUs.Projekto.data.repository;

import com._FoundUs.Projekto.data.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardsRepository extends JpaRepository<Cards, UUID> {
}