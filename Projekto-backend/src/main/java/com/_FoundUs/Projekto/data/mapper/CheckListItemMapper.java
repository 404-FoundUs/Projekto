package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.ChecklistItem;
import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckListItemMapper {

    ChecklistItemModel toModel(ChecklistItem checklistItem);
    ChecklistItem toEntity(ChecklistItemModel checklistItemModel);

}
