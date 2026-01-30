package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Comment;
import com._FoundUs.Projekto.domain.model.CommentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentModel toModel(Comment comment);
    Comment toEntity(CommentModel commentModel);

}
