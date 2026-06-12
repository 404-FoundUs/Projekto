package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.LablesModel;
import com._FoundUs.Projekto.presentation.dto.Lable.LabelRequestDto;
import com._FoundUs.Projekto.presentation.dto.Lable.LabelResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LabelApiMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cardIds", ignore = true)
    LablesModel toModel(LabelRequestDto dto);

    default LabelResponseDto toResponse(LablesModel model) {

        return LabelResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .boardId(model.getBoardId())
                .cardIds(model.getCardIds())
                .build();
    }
}
