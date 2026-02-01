package com._FoundUs.Projekto.domain.repository;


import com._FoundUs.Projekto.domain.model.LablesModel;

import java.util.List;
import java.util.UUID;

public interface LablesStore {
    LablesModel createLablesModel(LablesModel lablesModel);
    LablesModel updateLablesModel(UUID labelId,LablesModel lablesModel);
    void deleteLablesModel(UUID lableId);
    List<LablesModel> getLablesByBoard(UUID boardId);
    void assignToCard(UUID cardId, UUID labelId);
    void removeFromCard(UUID cardId, UUID labelId);
}
