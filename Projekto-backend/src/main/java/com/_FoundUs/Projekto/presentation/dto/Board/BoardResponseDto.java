package com._FoundUs.Projekto.presentation.dto.Board;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BoardResponseDto {
    private UUID id;
    private String name;
    private String description;
    private String visibility;
    private UUID workspaceId;
    private UUID createdBy;
    private List<UUID> lists;
    private List<UUID> labels;
}