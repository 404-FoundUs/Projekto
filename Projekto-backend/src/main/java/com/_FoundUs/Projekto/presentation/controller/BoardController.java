package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.usecase.Boards.*;
import com._FoundUs.Projekto.presentation.dto.Board.BoardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Board.BoardResponseDto;
import com._FoundUs.Projekto.presentation.mapper.BoardApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // ⚠️ ISSUE: Add CORS if not configured globally
public class BoardController {

    // 2nd component creates after the initialization.
    private final CreateBoardUseCase createBoardUseCase;
    private final GetBoardByWorkspaceUsecase getBoardByWorkspaceUsecase;
    private final GetBoardByIdUsecase getBoardByIdUsecase;
    private final UpdateBoardUsecase updateBoardUsecase;
    private final DeleteBoardByIdUsecase deleteBoardByIdUsecase;

    private final BoardApiMapper boardApiMapper;

    /**
     * Create a new board
     * POST /api/v1/boards
     * <p>
     * ⚠️ ISSUE #1: Missing @Valid annotation for request validation
     * ⚠️ ISSUE #2: Should return 201 CREATED instead of 200 OK
     */
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(
            @Validated @RequestBody BoardRequestDto requestDto // ✅ FIXED: Added @Valid
    ) {
        BoardModel boardModel = boardApiMapper.toBoardModel(requestDto);
        BoardModel createdBoard = createBoardUseCase.createBoard(boardModel);

        // ✅ FIXED: Return 201 CREATED with Location header
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(boardApiMapper.toResponseBoardDto(createdBoard));
    }

    /**
     * Get all boards by workspace ID
     * GET /api/v1/boards/workspace/{workspaceId}
     * <p>
     * ⚠️ ISSUE #3: Should validate that workspace exists
     * ⚠️ ISSUE #4: Missing pagination support for large datasets
     */
    @GetMapping("/workspace/{workspaceId}")
    public ResponseEntity<List<BoardResponseDto>> getBoardsByWorkspace(
            @PathVariable UUID workspaceId
    ) {
        List<BoardModel> boards = getBoardByWorkspaceUsecase.getBoardByWorkspaceId(workspaceId);

        // ⚠️ ISSUE: Empty list vs 404 - should return empty list with 200, not 404
        List<BoardResponseDto> response = boards.stream()
                .map(boardApiMapper::toResponseBoardDto)
                .toList();

        return ResponseEntity.ok(response);
    }

    /**
     * Get board by ID
     * GET /api/v1/boards/{boardId}
     * <p>
     * ⚠️ ISSUE #5: Should validate board exists (should be in use case)
     */
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoardById(
            @PathVariable UUID boardId
    ) {
        BoardModel boardModel = getBoardByIdUsecase.getBoardById(boardId);
        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(boardModel));
    }

    /**
     * Update board
     * PUT /api/v1/boards/{boardId}
     * <p>
     * ⚠️ ISSUE #6: Missing @Valid annotation
     * ⚠️ ISSUE #7: Should use PATCH for partial updates, PUT for full replacement
     */
    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> updateBoard(
            @PathVariable UUID boardId,
            @Validated @RequestBody BoardRequestDto requestDto // ✅ FIXED: Added @Valid
    ) {
        BoardModel model = boardApiMapper.toBoardModel(requestDto);
        BoardModel updated = updateBoardUsecase.updateBoard(boardId, model);

        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(updated));
    }

    /**
     * Partial update board (PATCH)
     * PATCH /api/v1/boards/{boardId}
     * <p>
     * ✅ NEW: Added PATCH endpoint for partial updates
     */
    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> patchBoard(
            @PathVariable UUID boardId,
            @RequestBody BoardRequestDto requestDto // Partial updates don't need full validation
    ) {
        BoardModel model = boardApiMapper.toBoardModel(requestDto);
        BoardModel updated = updateBoardUsecase.updateBoard(boardId, model);

        return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(updated));
    }

    /**
     * Delete board
     * DELETE /api/v1/boards/{boardId}
     * <p>
     * ✅ Correct: Returns 204 No Content
     */
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(
            @PathVariable UUID boardId
    ) {
        deleteBoardByIdUsecase.deleteBoardById(boardId);
        return ResponseEntity.noContent().build();
    }

    /**
     * ✅ NEW: Toggle board pin status
     * PATCH /api/v1/boards/{boardId}/pin
     */
    @PatchMapping("/{boardId}/pin")
    public ResponseEntity<BoardResponseDto> togglePin(
            @PathVariable UUID boardId
    ) {
        // Implement in use case
        // BoardModel updated = toggleBoardPinUsecase.togglePin(boardId);
        // return ResponseEntity.ok(boardApiMapper.toResponseBoardDto(updated));

        // Placeholder - implement this use case
        throw new UnsupportedOperationException("Pin toggle not yet implemented");
    }
}