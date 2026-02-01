package com._FoundUs.Projekto.domain.usecase.Boards;

import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteBoardByIdUsecase {
    private final BoardStore boardStore;

    public void deleteBoardById(UUID boardId) {
        boardStore.deleteBoardById(boardId);
    }
}
