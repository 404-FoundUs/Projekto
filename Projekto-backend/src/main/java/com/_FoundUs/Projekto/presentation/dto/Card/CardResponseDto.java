package com._FoundUs.Projekto.presentation.dto.Card;

import com._FoundUs.Projekto.domain.enums.Priority;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CardResponseDto {
    private UUID id;

    private String title;
    private String description;

    private Integer position;
    private LocalDateTime dueDate;

    private Priority priority;

    private UUID listId;
}
