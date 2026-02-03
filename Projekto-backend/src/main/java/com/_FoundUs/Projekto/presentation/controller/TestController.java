package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.repository.BoardStore;
import com._FoundUs.Projekto.presentation.dto.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {
    @PostMapping
    public ResponseEntity<String> receiveTestData(@RequestBody TestDto data) {
        System.out.println("Received data:");
        System.out.println("Name: " + data.getName());
        System.out.println("Value: " + data.getValue());

        // Return a response
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
