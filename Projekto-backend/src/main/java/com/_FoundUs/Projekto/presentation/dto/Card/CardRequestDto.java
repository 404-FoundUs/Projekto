package com._FoundUs.Projekto.presentation.dto.Card;


import com._FoundUs.Projekto.domain.enums.Priority;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CardRequestDto {
    private String title;
    private String description;

    private LocalDateTime dueDate;
    private Priority priority;

    private UUID listId;
}
