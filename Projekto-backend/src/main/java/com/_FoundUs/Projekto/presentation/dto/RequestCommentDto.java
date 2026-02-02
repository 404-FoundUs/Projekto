package com._FoundUs.Projekto.presentation.dto;


import lombok.*;

import java.util.UUID;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCommentDto {
    private String content;
    private UUID cardId;
    private UUID userId;
}
