package com._FoundUs.Projekto.presentation.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentDto {
    private UUID id;
    private String content;
    private UUID cardId;
    private UUID userId;
    private LocalDateTime createdAt;
}
