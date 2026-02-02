package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Checklist;
import com._FoundUs.Projekto.domain.model.ChecklistModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {

    ChecklistModel toModel(Checklist checklist);
    Checklist toEntity(ChecklistModel checklistModel);

}
