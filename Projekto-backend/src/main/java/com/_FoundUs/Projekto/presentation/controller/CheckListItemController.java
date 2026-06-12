package com._FoundUs.Projekto.presentation.controller;


import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.domain.usecase.checklistitem.CheckListItemCreateUseCase;
import com._FoundUs.Projekto.domain.usecase.checklistitem.CheckListItemDeleteUseCase;
import com._FoundUs.Projekto.domain.usecase.checklistitem.CheckListItemToggleUseCase;
import com._FoundUs.Projekto.domain.usecase.checklistitem.CheckListItemUpdateUseCase;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemRequestDto;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemResponseDto;
import com._FoundUs.Projekto.presentation.mapper.ChecklistItemApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/checklistitem")
@RequiredArgsConstructor
public class CheckListItemController {

    private final CheckListItemCreateUseCase  checkListItemCreateUseCase;
    private final CheckListItemUpdateUseCase checkListItemUpdateUseCase;
    private final CheckListItemDeleteUseCase checkListItemDeleteUseCase;
    private final CheckListItemToggleUseCase  checkListItemToggleUseCase;
    private final ChecklistItemApiMapper checklistItemApiMapper;


    @PostMapping("/{checklistId}")
    public ResponseEntity<ChecklistItemResponseDto> create(@PathVariable UUID checklistId, @RequestBody ChecklistItemRequestDto requestDto) {
        ChecklistItemModel listItemModel = checklistItemApiMapper.toModel(requestDto);
        ChecklistItemModel createlistItem = checkListItemCreateUseCase.create(checklistId, listItemModel);
        return new ResponseEntity<>(checklistItemApiMapper.toDto(createlistItem), HttpStatus.CREATED);

    }

    @PutMapping("/{checklistItemId}")
    public ResponseEntity<ChecklistItemResponseDto> update(@PathVariable UUID checklistItemId, @RequestBody ChecklistItemRequestDto requestDto) {
        ChecklistItemModel listItemModel = checklistItemApiMapper.toModel(requestDto);
        ChecklistItemModel updateListItem = checkListItemUpdateUseCase.update(checklistItemId, listItemModel);
        return ResponseEntity.ok(checklistItemApiMapper.toDto(updateListItem));
    }

    @DeleteMapping("/{checkListItemId}")
    public ResponseEntity<Void> delete(@PathVariable UUID checkListItemId) {
        checkListItemDeleteUseCase.delete(checkListItemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{checkListItemId}/toggle")
    public ResponseEntity<ChecklistItemResponseDto> toggle(@PathVariable UUID checkListItemId) {
        ChecklistItemModel toggleListItem = checkListItemToggleUseCase.toggle(checkListItemId);
        return ResponseEntity.ok(checklistItemApiMapper.toDto(toggleListItem));
    }



}
