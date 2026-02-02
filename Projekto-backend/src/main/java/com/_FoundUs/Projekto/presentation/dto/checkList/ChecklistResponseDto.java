package com._FoundUs.Projekto.presentation.dto.checkList;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.ChecklistItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistResponseDto {
    private UUID id;
    private String title;
    private Integer position;
    private Cards card;
    private List<ChecklistItem> items = new ArrayList<>();
}
