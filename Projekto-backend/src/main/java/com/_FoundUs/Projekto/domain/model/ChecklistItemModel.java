package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.Checklist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChecklistItemModel {
    private UUID id;
    private String content;
    private Boolean isCompleted;
    private Integer position;
    private UUID checklistId;
}
