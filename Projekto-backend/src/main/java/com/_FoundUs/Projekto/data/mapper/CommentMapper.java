package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Comment;
import com._FoundUs.Projekto.domain.model.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "cardId", source = "card.id")
    CommentModel toModel(Comment comment);
    Comment toEntity(CommentModel commentModel);

}
