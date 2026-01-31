package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.domain.model.BoardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {

    @Mapping(target = "workspaceId", source = "workspaceId.id")
    @Mapping(target = "createdBy", source = "createdBy.id")
    @Mapping(target = "lists", expression = "java(board.getLists() != null ? " +
            "board.getLists().stream().map(list -> list.getId()).collect(Collectors.toList()) : null)")
    @Mapping(target = "labels", expression = "java(board.getLabels() != null ? " +
            "board.getLabels().stream().map(label -> label.getId()).collect(Collectors.toList()) : null)")
    BoardModel toBoardModel(Board board);

}
