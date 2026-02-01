package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.BoardModel;

import java.util.List;
import java.util.UUID;

public interface BoardStore {
    BoardModel createBoard(BoardModel boardModel);
    List<BoardModel> getBoardByWorkspace(UUID workspaceId);
    BoardModel getBoardById(UUID boardId);
    BoardModel updateBoard(UUID boardId,BoardModel boardModel);
    void deleteBoardById(UUID boardId);
}
