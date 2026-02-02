package com._FoundUs.Projekto.presentation.dto.checkList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistReorderRequestDto {
    private List<UUID> orderedListIds;
}
