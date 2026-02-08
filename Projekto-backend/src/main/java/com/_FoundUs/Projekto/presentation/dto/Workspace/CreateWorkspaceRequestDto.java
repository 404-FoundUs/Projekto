package com._FoundUs.Projekto.presentation.dto.Workspace;

import com._FoundUs.Projekto.domain.enums.Visibility;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateWorkspaceRequestDto {
    private String name;
    private String description;
    private Visibility visibility;
    private UUID ownerId;
}
