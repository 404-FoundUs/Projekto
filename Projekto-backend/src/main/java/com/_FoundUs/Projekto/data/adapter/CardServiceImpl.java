package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Lists;
import com._FoundUs.Projekto.data.mapper.CardMapper;
import com._FoundUs.Projekto.data.repository.CardsRepository;
import com._FoundUs.Projekto.data.repository.ListsRepository;
import com._FoundUs.Projekto.domain.model.CardModel;
import com._FoundUs.Projekto.domain.repository.CardStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardServiceImpl implements CardStore {

    private final CardsRepository cardsRepository;
    private final ListsRepository listsRepository;
    private final CardMapper cardMapper;

    @Override
    public CardModel createCard(CardModel cardModel) {
        Lists list = listsRepository.findById(cardModel.getListId()).orElseThrow(()->new RuntimeException("list not found"));

        int nextPositions = cardsRepository.findByListOrderByPositionAsc(list).size();

        Cards cards = Cards.builder()
                .title(cardModel.getTitle())
                .description(cardModel.getDescription())
                .position(nextPositions)
                .list(list)
                .build();

        return cardMapper.toModel(cardsRepository.save(cards));
    }

    @Override
    public List<CardModel> getCardsByListId(UUID listId) {
        Lists list = listsRepository.findById(listId).orElseThrow(()->new RuntimeException("list not found"));

        return cardsRepository.findByListOrderByPositionAsc(list)
                .stream()
                .map(cardMapper::toModel)
                .collect(Collectors.toList());

    }

    @Override
    public CardModel getCardById(UUID cardId) {
        Cards cards = cardsRepository.findById(cardId).orElseThrow(()->new RuntimeException("card not found"));
        return cardMapper.toModel(cards);
    }

    @Override
    public CardModel updateCard(UUID cardId, CardModel cardModel) {
        Cards cards = cardsRepository.findById(cardId).orElseThrow(()->new RuntimeException("card not found"));
        cards.setTitle(cardModel.getTitle());
        cards.setDescription(cardModel.getDescription());
        return cardMapper.toModel(cardsRepository.save(cards));
    }

    @Override
    public void deleteCardById(UUID cardId) {
        Cards cards = cardsRepository.findById(cardId).orElseThrow(()->new RuntimeException("card not found"));
        cardsRepository.delete(cards);
    }

    @Override
    public CardModel moveCard(UUID cardId, UUID targetListId, Integer newPosition) {
        Cards card = cardsRepository.findById(cardId).orElseThrow(() -> new RuntimeException("card not found"));
        Lists targetList = listsRepository.findById(targetListId).orElseThrow(() -> new RuntimeException("list not found"));

        card.setList(targetList);

        List<Cards> cardsInList = cardsRepository.findByListOrderByPositionAsc(targetList);

        if (newPosition != null && newPosition < cardsInList.size()) {
            cardsInList.add(newPosition, card);
            for (int i = 0; i < cardsInList.size(); i++) {
                cardsInList.get(i).setPosition(i);
                cardsRepository.save(cardsInList.get(i));
            }
        } else {
            card.setPosition(cardsInList.size());
            cardsRepository.save(card);
        }

        return cardMapper.toModel(card);
    }


    @Override
    public void reorder(UUID listId, List<UUID> orderedCardIds) {
        Lists list = listsRepository.findById(listId).orElseThrow(()->new RuntimeException("list not found"));

        List<Cards> cards = cardsRepository.findByListOrderByPositionAsc(list);

        for (int i = 0; i < orderedCardIds.size(); i++) {
            UUID cardId = orderedCardIds.get(i);

            Cards card = cards.stream()
                    .filter(c -> c.getId().equals(cardId))
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("card not found"));

            card.setPosition(i);
            cardsRepository.save(card);
        }
    }
}
