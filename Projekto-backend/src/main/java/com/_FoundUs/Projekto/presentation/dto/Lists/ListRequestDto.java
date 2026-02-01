package com._FoundUs.Projekto.presentation.dto.Lists;

import lombok.Data;

import java.util.UUID;

@Data
public class ListRequestDto {
    private String title;
    private UUID boardId;
}

