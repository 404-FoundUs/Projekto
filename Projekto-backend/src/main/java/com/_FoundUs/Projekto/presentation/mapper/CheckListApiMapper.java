package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.ChecklistModel;
import com._FoundUs.Projekto.presentation.dto.checkList.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CheckListApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "cardId", ignore = true)
    @Mapping(target = "items", ignore = true)
    ChecklistModel toModel(ChecklistRequestDto checklistRequestDto);

    @Mapping(target = "card", source = "cardId")
    ChecklistResponseDto toDto(ChecklistModel checklistModel);

}
