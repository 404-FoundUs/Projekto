package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.ChecklistItemModel;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemRequestDto;
import com._FoundUs.Projekto.presentation.dto.checklistItem.ChecklistItemResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklistItemApiMapper {

    ChecklistItemModel toModel(ChecklistItemRequestDto checklistItemRequestDto);
    ChecklistItemResponseDto toDto(ChecklistItemModel checklistItemModel);

}
