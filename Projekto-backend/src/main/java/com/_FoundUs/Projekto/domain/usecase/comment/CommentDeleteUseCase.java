package com._FoundUs.Projekto.domain.usecase.comment;

import com._FoundUs.Projekto.domain.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentDeleteUseCase {

    private final CommentRepo commentRepo;

    public void delete(UUID id) {
        commentRepo.delete(id);
    }

}
