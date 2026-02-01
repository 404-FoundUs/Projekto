package com._FoundUs.Projekto.presentation.dto.Lable;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignLabelRequestDto {
    private UUID cardId;
    private UUID labelId;
}
