package com._FoundUs.Projekto.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentModel {
    private UUID id;
    private String content;
    private UUID cardId;
    private UUID userId;
    private LocalDateTime createdAt;
}
