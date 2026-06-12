package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Checklist;
import com._FoundUs.Projekto.data.mapper.ChecklistMapper;
import com._FoundUs.Projekto.data.repository.CardsRepository;
import com._FoundUs.Projekto.data.repository.ChecklistRepository;
import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.domain.repository.ChecklistStore;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListServiceImpl implements ChecklistStore {

    private final ChecklistMapper checklistMapper;
    private final ChecklistRepository checklistRepository;
    private final CardsRepository cardsRepository;

    @Override
    public ChecklistModel save(UUID cardId, ChecklistModel checklistModel) {
        Cards cardEntity = cardsRepository.findById(cardId).orElseThrow(() -> new EntityNotFoundException("Card Id not found"));
        Integer nextPosition = checklistRepository.findByCardOrderByPositionAsc(cardEntity).size();
        Checklist checklist = Checklist.builder()
                .card(cardEntity)
                .title(checklistModel.getTitle())
                .position(nextPosition).build();
        Checklist saveCheckList = checklistRepository.save(checklist);
        return checklistMapper.toModel(saveCheckList);
    }

    @Override
    public ChecklistModel update(UUID checklistId, ChecklistModel checklistModel) {

        Checklist checklistEntity = checklistRepository.findById(checklistId).orElseThrow(() -> new EntityNotFoundException("Checklist Id not found"));
        checklistEntity.setTitle(checklistModel.getTitle());
        Checklist updateChecklist = checklistRepository.save(checklistEntity);
        return checklistMapper.toModel(updateChecklist);
    }

    @Override
    public void delete(UUID id) {
        Checklist checklistEntity = checklistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Checklist Id not found"));
        checklistRepository.delete(checklistEntity);
    }

    @Override
    public void reorder(UUID cardId, List<UUID> orderedListIds) {
        Cards cards = cardsRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));

        List<Checklist> lists =
                checklistRepository.findByCardOrderByPositionAsc(cards);

        for (int i = 0; i < orderedListIds.size(); i++) {

            UUID listId = orderedListIds.get(i);

            Checklist column = lists.stream()
                    .filter(checklist -> checklist.getId().equals(listId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("List not found"));

            column.setPosition(i);
            checklistRepository.save(column);
        }

    }
}
