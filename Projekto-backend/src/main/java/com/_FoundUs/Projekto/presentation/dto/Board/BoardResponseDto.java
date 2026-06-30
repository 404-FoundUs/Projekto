package com._FoundUs.Projekto.presentation.dto.Board;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
/**
 * Board Response DTO
 * Used for returning board data to client
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // Don't include null fields in JSON
public class BoardResponseDto {

    private UUID id;

    private String name;

    private String description;

    private String visibility;

    private UUID workspaceId;

    /**
     * ⚠️ ISSUE #6: Exposing internal user IDs
     * Consider returning user details instead of just ID
     */
    private UUID createdBy;
    private String createdByName; // ✅ ADDED: More useful for frontend
    private String createdByAvatar; // ✅ ADDED: User avatar URL

    /**
     * ⚠️ ISSUE #7: Lists and labels should include more details
     */
    private List<UUID> lists; // Consider ListSummaryDto with id, name, order
    private List<UUID> labels; // Consider LabelDto with id, name, color

    /**
     * ⚠️ ISSUE #8: Missing important metadata
     */
    private LocalDateTime createdAt; // ✅ ADDED
    private LocalDateTime updatedAt; // ✅ ADDED
    private LocalDateTime lastActiveAt; // ✅ ADDED: For "Last active 2h ago"

    /**
     * ✅ NEW: Additional useful fields for frontend
     */
    private String color; // Board color
    private String icon;  // Board icon
    private Boolean pinned; // Is pinned

    /**
     * ✅ NEW: Statistics for progress tracking
     */
    private Integer totalTasks;
    private Integer completedTasks;
    private Integer progress; // Percentage 0-100

    /**
     * ✅ NEW: Member information
     */
    private List<MemberDto> members; // List of board members with avatars
    private Integer memberCount;

    /**
     * Nested DTO for member information
     */
    public static class MemberDto {
        private UUID id;
        private String name;
        private String email;
        private String avatarUrl;
        private String role; // OWNER, ADMIN, MEMBER, VIEWER
    }
}