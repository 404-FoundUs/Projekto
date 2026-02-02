package com._FoundUs.Projekto.domain.usecase.comment;

import com._FoundUs.Projekto.domain.model.CommentModel;
import com._FoundUs.Projekto.domain.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentUpdateUseCase {

    private final CommentRepo commentRepo;

    public CommentModel update(UUID id, CommentModel commentModel) {
        return commentRepo.update(id, commentModel);
    }

}
