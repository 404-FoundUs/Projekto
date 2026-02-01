package com._FoundUs.Projekto.domain.usecase.Lables;


import com._FoundUs.Projekto.domain.model.LablesModel;
import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateLablesModelUsecase {
    private final LablesStore lablesStore;

    public LablesModel updateLablesModel(UUID labelId, LablesModel lablesModel) {
        return lablesStore.updateLablesModel(labelId, lablesModel);
    }
}
