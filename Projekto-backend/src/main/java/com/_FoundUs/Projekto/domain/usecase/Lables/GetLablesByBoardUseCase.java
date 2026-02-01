package com._FoundUs.Projekto.domain.usecase.Lables;

import com._FoundUs.Projekto.domain.model.LablesModel;
import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetLablesByBoardUseCase {
    private final LablesStore lablesStore;

    public List<LablesModel> getLablesByBoard(UUID boardId) {
        return lablesStore.getLablesByBoard(boardId);
    }
}
