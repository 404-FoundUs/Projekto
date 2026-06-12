package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.domain.usecase.Lists.*;
import com._FoundUs.Projekto.presentation.dto.Lists.ListRequestDto;
import com._FoundUs.Projekto.presentation.dto.Lists.ListResponseDto;
import com._FoundUs.Projekto.presentation.dto.Lists.ReorderRequestDto;
import com._FoundUs.Projekto.presentation.mapper.ListApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/lists")
@RequiredArgsConstructor
public class ListsController {

    private final CreateListUsecase createListUseCase;
    private final GetListByBoardUsecase getListsByBoardUseCase;
    private final UpdateListUsecase updateListUseCase;
    private final DeleteListUsecase deleteListUseCase;
    private final ReorderListsUsecase reorderListsUseCase;

    private final ListApiMapper mapper;

    @PostMapping
    public ResponseEntity<ListResponseDto> createList(@RequestBody ListRequestDto requestDto) {
        ListModel created = createListUseCase.createList(mapper.toModel(requestDto));
        return ResponseEntity.ok(mapper.toResponse(created));
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<ListResponseDto>> getListByBoard(@PathVariable UUID boardId) {
        List<ListResponseDto> responseDtos = getListsByBoardUseCase.getListByBoard(boardId)
                .stream().map(mapper::toResponse).toList();

        return ResponseEntity.ok(responseDtos);
    }

    @PutMapping("/{listId}")
    public ResponseEntity<ListResponseDto> update(
            @PathVariable UUID listId,
            @RequestBody ListRequestDto dto
    ){
        ListModel updated =
                updateListUseCase.updateList(listId, mapper.toModel(dto));
        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity<Void> delete(@PathVariable UUID listId) {
        deleteListUseCase.deleteList(listId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/board/{boardId}/reorder")
    public ResponseEntity<Void> reorder(
            @PathVariable UUID boardId,
            @RequestBody ReorderRequestDto dto
    ){
        reorderListsUseCase.reorderLists(boardId, dto.getOrderedListIds());

        return ResponseEntity.ok().build();
    }
}
