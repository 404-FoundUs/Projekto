package com._FoundUs.Projekto.presentation.dto.Lable;

import lombok.Data;

import java.util.UUID;

@Data
public class LabelRequestDto {
    private String name;
    private String color;
    private UUID boardId;
}
