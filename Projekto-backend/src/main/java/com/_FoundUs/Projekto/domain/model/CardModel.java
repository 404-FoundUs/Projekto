package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.*;
import com._FoundUs.Projekto.domain.enums.Priority;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
public class CardModel {

    private UUID id;

    private String title;
    private String description;

    private Integer position;
    private LocalDateTime dueDate;

    private Priority priority;

    private UUID listId;
    private UUID boardId;

    private List<UUID> labelIds;
    private List<UUID> checklistIds;
    private List<UUID> commentIds;
}
