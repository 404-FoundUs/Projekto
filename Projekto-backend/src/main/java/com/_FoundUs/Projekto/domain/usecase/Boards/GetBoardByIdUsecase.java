package com._FoundUs.Projekto.domain.usecase.Boards;

import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetBoardByIdUsecase {
    private final BoardStore boardStore;

    public BoardModel getBoardById(UUID boardId) {
        return boardStore.getBoardById(boardId);
    }
}
