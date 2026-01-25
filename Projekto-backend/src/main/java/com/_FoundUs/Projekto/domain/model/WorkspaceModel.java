package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.domain.enums.Visibility;

import java.util.List;
import java.util.UUID;

public class WorkspaceModel {
    private UUID id;
    private String name;
    private String description;
    private Visibility visibility;
    private UUID ownerId;                 // entity avoid කරලා id use කරන්න
    private List<UUID> memberIds;
}
