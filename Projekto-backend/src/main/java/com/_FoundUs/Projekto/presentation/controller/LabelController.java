package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.usecase.Lables.*;
import com._FoundUs.Projekto.presentation.dto.Lable.AssignLabelRequestDto;
import com._FoundUs.Projekto.presentation.dto.Lable.LabelRequestDto;
import com._FoundUs.Projekto.presentation.dto.Lable.LabelResponseDto;
import com._FoundUs.Projekto.presentation.mapper.LabelApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/labels")
@RequiredArgsConstructor
public class LabelController {

    private final CreateLablesModelUsecase createUsecase;
    private final GetLablesByBoardUseCase getUsecase;
    private final UpdateLablesModelUsecase updateUsecase;
    private final DeleteLablesModelUsecase deleteUsecase;
    private final AssignToCardUsecase assignUsecase;
    private final RemoveFromCardUsecase removeUsecase;

    private final LabelApiMapper mapper;

    @PostMapping
    public ResponseEntity<LabelResponseDto> create(
            @RequestBody LabelRequestDto dto
    ) {
        return ResponseEntity.ok(
                mapper.toResponse(createUsecase.createLablesModel(mapper.toModel(dto)))
        );
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<LabelResponseDto>> getByBoard(
            @PathVariable UUID boardId
    ) {
        return ResponseEntity.ok(
                getUsecase.getLablesByBoard(boardId)
                        .stream()
                        .map(mapper::toResponse)
                        .collect(Collectors.toList())
        );
    }

    @PutMapping("/{labelId}")
    public ResponseEntity<LabelResponseDto> update(
            @PathVariable UUID labelId,
            @RequestBody LabelRequestDto dto
    ) {
        return ResponseEntity.ok(
                mapper.toResponse(updateUsecase.updateLablesModel(labelId, mapper.toModel(dto)))
        );
    }

    @DeleteMapping("/{labelId}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID labelId
    ) {
        deleteUsecase.deleteLablesModel(labelId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignToCard(
            @RequestBody AssignLabelRequestDto dto
    ) {
        assignUsecase.assignToCard(dto.getCardId(), dto.getLabelId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeFromCard(
            @RequestBody AssignLabelRequestDto dto
    ) {
        removeUsecase.removeFromCard(dto.getCardId(), dto.getLabelId());
        return ResponseEntity.ok().build();
    }
}
