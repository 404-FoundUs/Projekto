package com._FoundUs.Projekto.domain.usecase.Boards;

import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBoardUseCase {
    private final BoardStore boardStore;

    public BoardModel createBoard(BoardModel boardModel) {
        return boardStore.createBoard(boardModel);
    }
}
