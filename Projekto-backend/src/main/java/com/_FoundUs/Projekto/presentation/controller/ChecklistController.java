package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistDeleteUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistReorderUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistSaveUseCase;
import com._FoundUs.Projekto.domain.usecase.Checklist.ChecklistUpdateUseCase;
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

    private final ChecklistSaveUseCase  checklistSaveUseCase;
    private final ChecklistUpdateUseCase checklistUpdateUseCase;
    private final ChecklistDeleteUseCase checklistDeleteUseCase;
    private final ChecklistReorderUseCase checklistReorderUseCase;
    private final CheckListApiMapper  checkListApiMapper;

    @PostMapping("/{id}")
    public ResponseEntity<ChecklistResponseDto> save(@PathVariable UUID id, @RequestBody ChecklistRequestDto checklistRequestDto) {

        ChecklistModel checklistModel = checkListApiMapper.toModel(checklistRequestDto);
        ChecklistModel saveChecklist = checklistSaveUseCase.save(id, checklistModel);
        return new  ResponseEntity<>(checkListApiMapper.toDto(saveChecklist), HttpStatus.CREATED);

    }



}
