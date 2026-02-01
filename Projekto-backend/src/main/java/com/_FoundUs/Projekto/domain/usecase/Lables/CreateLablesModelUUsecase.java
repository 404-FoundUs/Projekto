package com._FoundUs.Projekto.domain.usecase.Lables;

import com._FoundUs.Projekto.domain.model.LablesModel;
import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateLablesModelUUsecase {
    private final LablesStore lablesStore;

    public LablesModel createLablesModel(LablesModel lablesModel) {
        return lablesStore.createLablesModel(lablesModel);
    }
}
