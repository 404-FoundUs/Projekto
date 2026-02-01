package com._FoundUs.Projekto.domain.usecase.Lists;

import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.domain.repository.ListsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetListByBoardUsecase {
    private final ListsStore listsStore;

    public List<ListModel> getListByBoard(UUID boardId) {
        return listsStore.getListByBoard(boardId);
    }
}
