package com._FoundUs.Projekto.presentation.mapper;


import com._FoundUs.Projekto.domain.model.CardModel;
import com._FoundUs.Projekto.presentation.dto.Cards.CardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Cards.CardResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CardApiMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "position", ignore = true)
    CardModel toModel(CardRequestDto dto);

    default CardResponseDto toResponse(CardModel model) {

        if (model == null) return null;

        return CardResponseDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .position(model.getPosition())
                .dueDate(model.getDueDate())
                .priority(model.getPriority())
                .listId(model.getListId())
                .build();
    }
}
