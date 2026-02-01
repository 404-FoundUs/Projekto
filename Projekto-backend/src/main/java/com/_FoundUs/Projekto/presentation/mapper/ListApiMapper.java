package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.ListModel;
import com._FoundUs.Projekto.presentation.dto.Lists.ListRequestDto;
import com._FoundUs.Projekto.presentation.dto.Lists.ListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ListApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "position", ignore = true)
    ListModel toModel(ListRequestDto dto);

    default ListResponseDto toResponse(ListModel model) {

        return ListResponseDto.builder()
                .id(model.getId())
                .name(model.getTitle())
                .position(model.getPosition())
                .boardId(model.getBoardId())
                .build();
    }
}
