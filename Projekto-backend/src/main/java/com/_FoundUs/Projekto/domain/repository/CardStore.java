package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.CardModel;

import java.util.List;
import java.util.UUID;

public interface CardStore {
    CardModel createCard(CardModel cardModel);
    List<CardModel>  getCardsByListId(UUID listId);
    CardModel getCardById(UUID cardId);
    CardModel updateCard(UUID cardId, CardModel cardModel);
    void deleteCardById(UUID cardId);
    void moveCard(UUID cardId, UUID targetListId);
    void reorder(UUID listId, List<UUID> orderedCardIds);
}
