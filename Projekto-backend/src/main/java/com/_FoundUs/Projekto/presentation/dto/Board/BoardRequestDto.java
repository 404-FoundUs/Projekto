package com._FoundUs.Projekto.presentation.dto.Board;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import java.util.UUID;

@Data
public class BoardRequestDto {

    private String name;


    private String description;

    private String visibility; // Consider using enum: VisibilityType

    private UUID workspaceId;

    private UUID createdBy; // ✅ This should be set server-side from auth token

    private String color; // Board color for UI
    private String icon;  // Board icon name
    private Boolean pinned; // Is board pinned
}