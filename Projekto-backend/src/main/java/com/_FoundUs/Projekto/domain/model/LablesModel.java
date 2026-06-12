package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Cards;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class LablesModel {
    private UUID id;
    private String name;
    private String color;
    private UUID boardId;
    private List<UUID> cardIds;
}
