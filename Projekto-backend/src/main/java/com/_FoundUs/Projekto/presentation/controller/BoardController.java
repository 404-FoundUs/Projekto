package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.usecase.Boards.*;
import com._FoundUs.Projekto.presentation.dto.Board.BoardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Board.BoardResponseDto;
import com._FoundUs.Projekto.presentation.mapper.BoardApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;
    private final GetBoardByWorkspaceUsecase getBoardByWorkspaceUsecase;
    private final GetBoardByIdUsecase getBoardByIdUsecase;
    private final UpdateBoardUsecase updateBoardUsecase;
    private final DeleteBoardByIdUsecase deleteBoardByIdUsecase;

    private final BoardApiMapper boardApiMapper;

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto requestDto) {
        BoardModel boardModel = boardApiMapper.toBoardModel(requestDto);

        BoardModel createdBoard = createBoardUseCase.createBoard(boardModel);

        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(createdBoard));
    }

    @GetMapping("/workspace/{workspaceId}")
    public ResponseEntity<List<BoardResponseDto>> getBoardsByWorkspace(
            @PathVariable UUID workspaceId
    ) {
        List<BoardModel> boards =
                getBoardByWorkspaceUsecase.getBoardByWorkspaceId(workspaceId);
        List<BoardResponseDto> response =
                boards.stream().map(boardApiMapper::toResponseBoardDto).toList();

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoardById(
            @PathVariable UUID boardId
    ) {
        BoardModel boardModel = getBoardByIdUsecase.getBoardById(boardId);
        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(boardModel));
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> updateBoard(
            @PathVariable UUID boardId,
            @RequestBody BoardRequestDto requestDto
    ) {
        BoardModel model = boardApiMapper.toBoardModel(requestDto);

        BoardModel updated = updateBoardUsecase.updateBoard(boardId, model);

        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(updated));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(
            @PathVariable UUID boardId
    ) {
        deleteBoardByIdUsecase.deleteBoardById(boardId);

        return ResponseEntity.noContent().build();
    }
}
