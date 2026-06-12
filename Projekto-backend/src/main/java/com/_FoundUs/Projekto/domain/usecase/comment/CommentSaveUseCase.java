package com._FoundUs.Projekto.domain.usecase.comment;

import com._FoundUs.Projekto.domain.repository.CommentRepo;
import com._FoundUs.Projekto.domain.model.CommentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentSaveUseCase {
    private final CommentRepo commentRepo;

    public CommentModel save(CommentModel commentModel) {
        return commentRepo.save(commentModel);
    }

}
