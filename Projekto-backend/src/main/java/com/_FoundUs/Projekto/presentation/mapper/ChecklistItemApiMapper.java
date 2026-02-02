package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemRequestDto;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChecklistItemApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isCompleted", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "checklistId", ignore = true)
    ChecklistItemModel toModel(ChecklistItemRequestDto checklistItemRequestDto);
    ChecklistItemResponseDto toDto(ChecklistItemModel checklistItemModel);

}
