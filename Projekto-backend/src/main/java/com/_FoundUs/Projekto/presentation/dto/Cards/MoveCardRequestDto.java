package com._FoundUs.Projekto.presentation.dto.Cards;

import lombok.Data;

import java.util.UUID;

@Data
public class MoveCardRequestDto {
    private UUID targetListId;
    private Integer newPosition;
}
