package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Lists;
import com._FoundUs.Projekto.domain.model.ListModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ListsMapper {
    @Mapping(target = "boardId", source = "boardId.id")
    @Mapping(
            target = "cards",
            expression =
                    "java(lists.getCards() != null ? " +
                            "lists.getCards().stream()" +
                            ".map(card -> card.getId())" +
                            ".toList() : null)"
    )
    ListModel toListModel(Lists lists);
}
