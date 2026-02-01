package com._FoundUs.Projekto.domain.usecase.Boards;

import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetBoardByWorkspaceUsecase {
    private final BoardStore boardStore;

    public List<BoardModel> getBoardByWorkspaceId(UUID workspaceId) {
        return boardStore.getBoardByWorkspace(workspaceId);
    }

}
