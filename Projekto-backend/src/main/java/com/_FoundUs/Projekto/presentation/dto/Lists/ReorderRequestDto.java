package com._FoundUs.Projekto.presentation.dto.Lists;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ReorderRequestDto {
    private List<UUID> orderedListIds;
}
