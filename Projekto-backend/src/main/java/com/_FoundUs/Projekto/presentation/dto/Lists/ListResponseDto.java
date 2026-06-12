package com._FoundUs.Projekto.presentation.dto.Lists;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ListResponseDto {
    private UUID id;
    private String name;
    private Integer position;
    private UUID boardId;
}
