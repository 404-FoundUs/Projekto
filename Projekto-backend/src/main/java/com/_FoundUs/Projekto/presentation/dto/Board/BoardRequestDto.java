package com._FoundUs.Projekto.presentation.dto.Board;

import lombok.Data;

import java.util.UUID;

@Data
public class BoardRequestDto {
    private String name;
    private String description;
    private String visibility;
    private UUID workspaceId;
    private UUID createdBy;
}
