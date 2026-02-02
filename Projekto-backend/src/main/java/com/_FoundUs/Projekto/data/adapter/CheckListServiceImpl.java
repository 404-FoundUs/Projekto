package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.mapper.ChecklistMapper;
import com._FoundUs.Projekto.data.repository.ChecklistRepository;
import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.repository.ChecklistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListServiceImpl implements ChecklistStore {

    private final ChecklistMapper checklistMapper;
    private final ChecklistRepository checklistRepository;

    @Override
    public ChecklistModel save(UUID cardId, ChecklistModel checklistModel) {

        System.out.println("Checklistmodel " +checklistModel);

        return null;
    }

    @Override
    public ChecklistModel update(UUID cardId, ChecklistModel checklistModel) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public ChecklistModel reorder(UUID checklistId, ChecklistModel checklistModel) {
        return null;
    }
}
