package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.BoardModel;
import com._FoundUs.Projekto.presentation.dto.Board.BoardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Board.BoardResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface BoardApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lists", ignore = true)
    @Mapping(target = "labels", ignore = true)
    BoardModel toBoardModel(BoardRequestDto requestDto);

    default BoardResponseDto toResponseBoardDto(BoardModel model) {

        if (model == null) return null;

        return BoardResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .visibility(model.getVisibility())
                .workspaceId(model.getWorkspaceId())
                .createdBy(model.getCreatedBy())
                .lists(model.getLists())
                .labels(model.getLabels())
                .build();
    }
}
