package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Checklist;
import com._FoundUs.Projekto.data.entity.ChecklistItem;
import com._FoundUs.Projekto.data.mapper.CheckListItemMapper;
import com._FoundUs.Projekto.data.repository.ChecklistItemRepository;
import com._FoundUs.Projekto.data.repository.ChecklistRepository;
import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.domain.repository.CheckListItemStore;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckListItemServiceImpl implements CheckListItemStore {

    private final CheckListItemMapper checkListItemMapper;
    private final ChecklistRepository checklistRepository;
    private final ChecklistItemRepository checklistItemRepository;


    @Override
    public ChecklistItemModel create(UUID checklistId, ChecklistItemModel checklistItemModel) {

        Checklist checklist = checklistRepository.findById(checklistId).orElseThrow(() -> new EntityNotFoundException("Checklist Not Found"));

        Integer nextPosition = checklistItemRepository.findByChecklistIdOrderByPositionAsc(checklist).size();

        ChecklistItem checklistItem = ChecklistItem.builder()
                .checklist(checklist)
                .content(checklistItemModel.getContent())
                .isCompleted(false)
                .position(nextPosition)
                .build();


        ChecklistItem saveListItem = checklistItemRepository.save(checklistItem);

        return checkListItemMapper.toModel(saveListItem);
    }

    @Override
    public ChecklistItemModel update(UUID listItemId, ChecklistItemModel checklistItemModel) {
        ChecklistItem checklistItem = checklistItemRepository.findById(listItemId).orElseThrow(() -> new EntityNotFoundException("Checklist Not Found"));
        checklistItem.setContent(checklistItemModel.getContent());
        ChecklistItem updateListItem = checklistItemRepository.save(checklistItem);
        return checkListItemMapper.toModel(updateListItem);
    }

    @Override
    public void delete(UUID checklistItemId) {

        ChecklistItem checklistItem = checklistItemRepository.findById(checklistItemId).orElseThrow(() -> new EntityNotFoundException("Checklist Not Found"));
        UUID listId = checklistItem.getChecklist().getId();
        Integer position = checklistItem.getPosition();
        reorderChecklistItemAfterDeletion(listId, position);
        checklistItemRepository.deleteById(checklistItemId);


    }

    @Override
    public ChecklistItemModel toggle(UUID checklistItemId) {
        ChecklistItem checklistItem = checklistItemRepository.findById(checklistItemId).orElseThrow(() -> new EntityNotFoundException("Checklist Not Found"));
        checklistItem.setIsCompleted(!checklistItem.getIsCompleted());
        ChecklistItem toggleListItem = checklistItemRepository.save(checklistItem);
        return checkListItemMapper.toModel(toggleListItem);
    }

    private void reorderChecklistItemAfterDeletion(UUID checklistItemId, Integer position) {
        List<ChecklistItem> itemReorder = checklistItemRepository.findByChecklistIdAndPositionGreaterThanEqualOrderByPositionAsc(checklistItemId, position);
        itemReorder.forEach(item -> item.setPosition(item.getPosition() - 1));
        checklistItemRepository.saveAll(itemReorder);

    }
}
