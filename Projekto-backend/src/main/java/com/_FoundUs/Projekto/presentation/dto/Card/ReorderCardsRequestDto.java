package com._FoundUs.Projekto.presentation.dto.Card;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ReorderCardsRequestDto {
    private List<UUID> orderedCardIds;
}
