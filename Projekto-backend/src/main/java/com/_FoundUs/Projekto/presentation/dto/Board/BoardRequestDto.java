package com._FoundUs.Projekto.presentation.dto.Board;

import lombok.Data;

import java.util.UUID;

@Data
public class BoardRequestDto {

    /**
     * ⚠️ ISSUE #1: Missing validation constraints
     */
    @NotBlank(message = "Board name is required")
    @Size(min = 1, max = 100, message = "Board name must be between 1 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    /**
     * ⚠️ ISSUE #2: Visibility should be an enum, not String
     * ⚠️ ISSUE #3: Missing default value
     */
    @NotNull(message = "Visibility is required")
    @Pattern(regexp = "PUBLIC|PRIVATE|WORKSPACE", message = "Visibility must be PUBLIC, PRIVATE, or WORKSPACE")
    private String visibility; // Consider using enum: VisibilityType

    /**
     * ⚠️ ISSUE #4: workspaceId is required but not validated
     */
    @NotNull(message = "Workspace ID is required")
    private UUID workspaceId;

    /**
     * ⚠️ ISSUE #5: createdBy should come from authentication context, not request body
     * This is a SECURITY ISSUE - client should not control who created the board
     */
    // @NotNull(message = "Creator ID is required") // ❌ REMOVE THIS
    private UUID createdBy; // ✅ This should be set server-side from auth token

    /**
     * ✅ NEW: Additional useful fields
     */
    private String color; // Board color for UI
    private String icon;  // Board icon name
    private Boolean pinned; // Is board pinned
}