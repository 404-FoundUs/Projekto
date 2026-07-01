package com._FoundUs.Projekto.presentation.dto.Card;

import lombok.Data;

import java.util.UUID;

@Data
public class MoveCardRequestDto {
    private UUID targetListId;
    private Integer newPosition;
}
