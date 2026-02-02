package com._FoundUs.Projekto.presentation.dto.checklistItem;

import com._FoundUs.Projekto.data.entity.Checklist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistItemResponseDto {
    private UUID id;
    private String content;
    private Boolean isCompleted = false;
    private Integer position;
    private Checklist checklist;
}
