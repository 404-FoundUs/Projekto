package com._FoundUs.Projekto.presentation.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorApi {
    private int status;
    private String message;
    private List<ErrorField> error;

    @Data
    @Builder
    private static class ErrorField{
        private int status;
        private String message;
        private String field;
    }
}
