package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.CommentModel;
import com._FoundUs.Projekto.domain.usecase.comment.CommentDeleteUseCase;
import com._FoundUs.Projekto.domain.usecase.comment.CommentSaveUseCase;
import com._FoundUs.Projekto.domain.usecase.comment.CommentUpdateUseCase;
import com._FoundUs.Projekto.presentation.dto.RequestCommentDto;
import com._FoundUs.Projekto.presentation.dto.ResponseCommentDto;
import com._FoundUs.Projekto.presentation.mapper.CommentApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentApiMapper commentApiMapper;
    private final CommentSaveUseCase commentSaveUseCase;
    private final CommentUpdateUseCase commentUpdateUseCase;
    private final CommentDeleteUseCase commentDeleteUseCase;

    @PostMapping
    public ResponseEntity<ResponseCommentDto> save(@RequestBody RequestCommentDto requestCommentDto) {

        CommentModel commentModel = commentApiMapper.toModel(requestCommentDto);
        CommentModel saveComment = commentSaveUseCase.save(commentModel);
        ResponseCommentDto dto = commentApiMapper.toDto(saveComment);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCommentDto> update(@PathVariable UUID id, @RequestBody RequestCommentDto requestCommentDto) {
        CommentModel commentModel = commentApiMapper.toModel(requestCommentDto);
        CommentModel updateComment = commentUpdateUseCase.update(id, commentModel);
        return ResponseEntity.ok(commentApiMapper.toDto(updateComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        commentDeleteUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
