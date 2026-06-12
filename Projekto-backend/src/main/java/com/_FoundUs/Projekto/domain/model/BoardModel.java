package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Labels;
import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BoardModel {

    private UUID id;
    private String name;
    private String description;
    private String visibility;
    private UUID workspaceId;
    private UUID createdBy;
    private List<UUID> lists;
    private List<UUID> labels = new ArrayList<>();
}
