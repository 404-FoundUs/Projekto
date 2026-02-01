package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Lists;
import com._FoundUs.Projekto.data.mapper.ListsMapper;
import com._FoundUs.Projekto.data.repository.BoardRepository;
import com._FoundUs.Projekto.data.repository.ListsRepository;
import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.domain.repository.ListsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ListsServiceImpl implements ListsStore {

    private final ListsRepository listsRepository;
    private final BoardRepository boardRepository;
    private final ListsMapper listsMapper;

    @Override
    public ListModel createList(ListModel listModel) {

        Board board = boardRepository.findById(listModel.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found"));

        int nextPosition =
                listsRepository.findByBoardIdOrderByPositionAsc(board).size();

        Lists lists = Lists.builder()
                .title(listModel.getTitle())
                .position(nextPosition)
                .boardId(board)
                .build();

        return listsMapper.toListModel(listsRepository.save(lists));
    }

    @Override
    public List<ListModel> getListByBoard(UUID boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new RuntimeException("Board not found"));

        return listsRepository.findByBoardIdOrderByPositionAsc(board)
                .stream()
                .map(listsMapper::toListModel)
                .collect(Collectors.toList());
    }

    @Override
    public ListModel updateList(UUID id, ListModel listModel) {
        Lists list = listsRepository.findById(id).orElseThrow(()-> new RuntimeException("Lists Not Found"));

        list.setTitle(listModel.getTitle());

        return listsMapper.toListModel(listsRepository.save(list));

    }

    @Override
    public void deleteList(UUID id) {
        Lists list = listsRepository.findById(id).orElseThrow(()-> new RuntimeException("Lists Not Found"));
        listsRepository.delete(list);
    }

    @Override
    public void reorderLists(UUID boardId, List<UUID> orderedListIds) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));

        List<Lists> lists =
                listsRepository.findByBoardIdOrderByPositionAsc(board);

        for (int i = 0; i < orderedListIds.size(); i++) {

            UUID listId = orderedListIds.get(i);

            Lists column = lists.stream()
                    .filter(l -> l.getId().equals(listId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("List not found"));

            column.setPosition(i);
            listsRepository.save(column);
        }
    }
}
