package com._FoundUs.Projekto.presentation.error;

import com._FoundUs.Projekto.presentation.dto.ErrorApi;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorApi> handleEntityNotFoundException(EntityNotFoundException ex){
        ErrorApi errorApi = ErrorApi.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorApi, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorApi> handleIllegalArgumentException(IllegalArgumentException ex){
            ErrorApi errorApi = ErrorApi.builder()
                    .status(HttpStatus.NO_CONTENT.value())
                    .message(ex.getMessage())
                    .build();
                return new ResponseEntity<>(errorApi, HttpStatus.NO_CONTENT);
    }
}
