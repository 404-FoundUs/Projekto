package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.data.mapper.BoardMapper;
import com._FoundUs.Projekto.data.mapper.WorkspaceMapper;
import com._FoundUs.Projekto.data.repository.BoardRepository;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.data.repository.WorkspaceRepository;
import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.domain.repository.BoardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardStore {

    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;
    private final BoardMapper boardMapper;

    @Override
    public BoardModel createBoard(BoardModel boardModel) {
        User user = userRepository.findById(boardModel.getCreatedBy()).orElseThrow(()-> new RuntimeException("User not found"));

        Workspace workspace = workspaceRepository.findById(boardModel.getWorkspaceId()).orElseThrow(()-> new RuntimeException("Workspace not found"));

        if (!workspace.getOwner().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to create boards in this workspace");
        }

        Board board = Board.builder()
                .name(boardModel.getName())
                .description(boardModel.getDescription())
                .visibility(boardModel.getVisibility())
                .workspaceId(workspace)
                .createdBy(user)
                .build();

        return  boardMapper.toBoardModel(boardRepository.save(board));

    }

    @Override
    public List<BoardModel> getBoardByWorkspace(UUID workspaceId) {
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow(()-> new RuntimeException("Workspace not found"));

        return boardRepository.findByWorkspaceId(workspace)
                .stream()
                .map(boardMapper::toBoardModel)
                .toList();
    }

    @Override
    public BoardModel getBoardById(UUID boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new RuntimeException("Board not found"));
        return boardMapper.toBoardModel(board);
    }

    @Override
    public BoardModel updateBoard(UUID boardId, BoardModel boardModel) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new RuntimeException("Board not found"));

        board.setName(boardModel.getName());
        board.setDescription(boardModel.getDescription());
        board.setVisibility(boardModel.getVisibility());

        Board updatedBoard = boardRepository.save(board);

        return boardMapper.toBoardModel(updatedBoard);
    }

    @Override
    public void deleteBoardById(UUID boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new RuntimeException("Board not found"));

        boardRepository.delete(board);
    }
}
