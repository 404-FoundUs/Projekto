package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.domain.model.CommentModel;
import com._FoundUs.Projekto.presentation.dto.RequestCommentDto;
import com._FoundUs.Projekto.presentation.dto.ResponseCommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentApiMapper {

    @Mapping(target = "id",  ignore = true)
    CommentModel toModel(RequestCommentDto requestCommentDto);
    ResponseCommentDto toDto(CommentModel commentModel);

}
