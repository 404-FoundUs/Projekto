package com._FoundUs.Projekto.domain.model;


import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Cards;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ListModel {
    private UUID id;
    private String title;
    private Integer position;
    private List<UUID> cards = new ArrayList<>();
    private UUID boardId;
}
