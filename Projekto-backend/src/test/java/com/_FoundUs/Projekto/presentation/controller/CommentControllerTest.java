package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.CommentModel;
import com._FoundUs.Projekto.domain.usecase.comment.CommentDeleteUseCase;
import com._FoundUs.Projekto.domain.usecase.comment.CommentSaveUseCase;
import com._FoundUs.Projekto.domain.usecase.comment.CommentUpdateUseCase;
import com._FoundUs.Projekto.presentation.dto.RequestCommentDto;
import com._FoundUs.Projekto.presentation.dto.ResponseCommentDto;
import com._FoundUs.Projekto.presentation.mapper.CommentApiMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CommentController.class)
@DisplayName("Comment Controller Test")
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CommentSaveUseCase commentSaveUseCase;

    @MockitoBean
    private CommentUpdateUseCase commentUpdateUseCase;

    @MockitoBean
    private CommentDeleteUseCase commentDeleteUseCase;

    @MockitoBean
    private CommentApiMapper commentApiMapper;

    @Test
    @DisplayName("POST /api/v1/comment - should create comment")
    void shouldSaveComment() throws Exception {
        UUID userId = UUID.randomUUID();
        UUID cardId = UUID.randomUUID();
        UUID commentId = UUID.randomUUID();

        RequestCommentDto request = RequestCommentDto.builder()
                .content("Test Content")
                .userId(userId)
                .cardId(cardId)
                .build();

        CommentModel model = CommentModel.builder().build();

        ResponseCommentDto response = ResponseCommentDto.builder()
                .id(commentId)
                .content("Test Content")
                .build();

        Mockito.when(commentApiMapper.toModel(request)).thenReturn(model);
        Mockito.when(commentSaveUseCase.save(model)).thenReturn(model);
        Mockito.when(commentApiMapper.toDto(model)).thenReturn(response);

        mockMvc.perform(post("/api/v1/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("Test Content"));
    }

    @Test
    @DisplayName("PUT /api/v1/comment/{id} - should update comment")
    void shouldUpdateComment() throws Exception {
        UUID commentId = UUID.randomUUID();

        RequestCommentDto request = RequestCommentDto.builder()
                .content("Updated Content")
                .build();

        CommentModel model = CommentModel.builder().build();

        ResponseCommentDto response = ResponseCommentDto.builder()
                .id(commentId)
                .content("Updated Content")
                .build();

        Mockito.when(commentApiMapper.toModel(request)).thenReturn(model);
        Mockito.when(commentUpdateUseCase.update(commentId, model)).thenReturn(model);
        Mockito.when(commentApiMapper.toDto(model)).thenReturn(response);

        mockMvc.perform(put("/api/v1/comment/{id}", commentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(commentId.toString()))
                .andExpect(jsonPath("$.content").value("Updated Content"));
    }

    @Test
    @DisplayName("DELETE /api/v1/comment/{id} - should delete comment")
    void shouldDeleteComment() throws Exception {
        UUID commentId = UUID.randomUUID();

        mockMvc.perform(delete("/api/v1/comment/{id}", commentId))
                .andExpect(status().isNoContent());

        Mockito.verify(commentDeleteUseCase).delete(commentId);
    }
}
