package com._FoundUs.Projekto.domain.usecase.Checklist;

import com._FoundUs.Projekto.domain.repository.ChecklistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChecklistDeleteUseCase {

    private final ChecklistStore checklistStore;

    public void delete(UUID checklistId) {
        checklistStore.delete(checklistId);
    }

}
