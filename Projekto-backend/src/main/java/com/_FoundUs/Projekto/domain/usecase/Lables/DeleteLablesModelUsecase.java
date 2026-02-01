package com._FoundUs.Projekto.domain.usecase.Lables;

import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteLablesModelUsecase {
    private final LablesStore lablesStore;

    public void deleteLablesModel(UUID lableId) {
        lablesStore.deleteLablesModel(lableId);
    }
}
