package com._FoundUs.Projekto.presentation.dto.Lable;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class LabelResponseDto {
    private UUID id;
    private String name;
    private String color;
    private UUID boardId;

    private List<UUID> cardIds;
}
