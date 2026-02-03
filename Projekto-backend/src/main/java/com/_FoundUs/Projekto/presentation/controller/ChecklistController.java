package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistDeleteUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistReorderUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistSaveUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistUpdateUseCase;
import com._FoundUs.Projekto.presentation.dto.checkList.ChecklistReorderRequestDto;
import com._FoundUs.Projekto.presentation.dto.checkList.ChecklistRequestDto;
import com._FoundUs.Projekto.presentation.dto.checkList.ChecklistResponseDto;
import com._FoundUs.Projekto.presentation.mapper.CheckListApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/checklist")
@RequiredArgsConstructor
public class ChecklistController {

    private final ChecklistSaveUseCase checklistSaveUseCase;
    private final ChecklistUpdateUseCase checklistUpdateUseCase;
    private final ChecklistDeleteUseCase checklistDeleteUseCase;
    private final ChecklistReorderUseCase checklistReorderUseCase;
    private final CheckListApiMapper checkListApiMapper;

    @PostMapping("/{cardId}")
    public ResponseEntity<ChecklistResponseDto> save(@PathVariable UUID cardId, @RequestBody ChecklistRequestDto checklistRequestDto) {
        ChecklistModel checklistModel = checkListApiMapper.toModel(checklistRequestDto);
        ChecklistModel saveChecklist = checklistSaveUseCase.save(cardId, checklistModel);
        return new ResponseEntity<>(checkListApiMapper.toDto(saveChecklist), HttpStatus.CREATED);
    }

    @PutMapping("/{checklistId}")
    public ResponseEntity<ChecklistResponseDto> update(@PathVariable UUID checklistId, @RequestBody ChecklistRequestDto checklistRequestDto) {
        ChecklistModel checklistModel = checkListApiMapper.toModel(checklistRequestDto);
        ChecklistModel checkListUpdate = checklistUpdateUseCase.update(checklistId, checklistModel);
        return ResponseEntity.ok(checkListApiMapper.toDto(checkListUpdate));
    }

    @DeleteMapping("/{checklistId}")
    public ResponseEntity<Void> delete(@PathVariable UUID checklistId) {
        checklistDeleteUseCase.delete(checklistId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("card/{cardId}/reorder")
    public ResponseEntity<Void> reorder(@PathVariable UUID cardId, @RequestBody ChecklistReorderRequestDto dto) {
        checklistReorderUseCase.reorder(cardId,dto.getOrderedListIds());
        return ResponseEntity.noContent().build();
    }
}
