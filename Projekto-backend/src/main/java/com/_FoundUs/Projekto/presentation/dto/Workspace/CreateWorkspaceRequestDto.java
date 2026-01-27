package com._FoundUs.Projekto.presentation.dto.Workspace;

import com._FoundUs.Projekto.domain.enums.Visibility;
import lombok.Data;

@Data
public class CreateWorkspaceRequestDto {
    private String name;
    private String description;
    private Visibility visibility;
}
