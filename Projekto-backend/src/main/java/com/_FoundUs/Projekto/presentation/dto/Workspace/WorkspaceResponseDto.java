package com._FoundUs.Projekto.presentation.dto.Workspace;

import com._FoundUs.Projekto.domain.enums.Visibility;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WorkspaceResponseDto {
    private UUID id;
    private String name;
    private String description;
    private Visibility visibility;
    private UUID ownerId;
    private List<UUID> memberIds;
}
