package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.domain.enums.Visibility;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WorkspaceModel {
    private UUID id;
    private String name;
    private String description;
    private Visibility visibility;
    private UUID ownerId;
    private List<UUID> memberIds;
}
