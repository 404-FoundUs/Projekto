package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.domain.model.CardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

    @Mapping(target = "listId", source = "list.id")
    CardModel toModel(Cards card);
}
