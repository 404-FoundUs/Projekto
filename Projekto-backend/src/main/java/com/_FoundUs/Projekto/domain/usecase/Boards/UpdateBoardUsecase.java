package com._FoundUs.Projekto.domain.usecase.Boards;

import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateBoardUsecase {
    private final BoardStore boardStore;

    public BoardModel updateBoard(UUID workspaceId, BoardModel boardModel) {
        return boardStore.updateBoard(workspaceId, boardModel);
    }
}
