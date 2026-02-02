package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Checklist;
import com._FoundUs.Projekto.domain.model.ChecklistModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {

    @Mapping(target = "cardId", source = "card.id")
    ChecklistModel toModel(Checklist checklist);
    Checklist toEntity(ChecklistModel checklistModel);

}
