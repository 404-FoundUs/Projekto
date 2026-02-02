package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.ChecklistItem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChecklistModel {

    private UUID id;
    private String title;
    private Integer position;
    private Cards card;
    private List<ChecklistItem> items = new ArrayList<>();
}
