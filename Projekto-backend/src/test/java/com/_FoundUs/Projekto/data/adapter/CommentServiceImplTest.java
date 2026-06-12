package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Comment;
import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.mapper.CommentMapper;
import com._FoundUs.Projekto.data.repository.CardsRepository;
import com._FoundUs.Projekto.data.repository.CommentRepository;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.domain.model.CommentModel;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("CommentServiceImpl Tests")
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CardsRepository cardsRepository;

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private UUID userId;
    private UUID cardId;
    private UUID commentId;

    private User user;
    private Cards cards;
    private Comment comment;
    private CommentModel commentModel;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        cardId = UUID.randomUUID();
        commentId = UUID.randomUUID();

        user = User.builder().id(userId).build();
        cards = Cards.builder().id(cardId).build();

        comment = Comment.builder()
                .id(commentId)
                .content("Initial content")
                .user(user)
                .card(cards)
                .build();

        commentModel = CommentModel.builder()
                .id(commentId)
                .content("Updated content")
                .userId(userId)
                .cardId(cardId)
                .build();
    }

    @Test
    @DisplayName("save - should save comment successfully")
    void save_shouldSaveComment() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(cardsRepository.findById(cardId)).thenReturn(Optional.of(cards));
        when(commentMapper.toEntity(commentModel)).thenReturn(comment);
        when(commentRepository.save(comment)).thenReturn(comment);
        when(commentMapper.toModel(comment)).thenReturn(commentModel);

        CommentModel result = commentService.save(commentModel);

        assertNotNull(result);
        verify(commentRepository).save(comment);
    }

    @Test
    @DisplayName("save - should throw when user not found")
    void save_shouldThrowWhenUserNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> commentService.save(commentModel));
    }


    @Test
    @DisplayName("update - should update comment when user is owner")
    void update_shouldUpdateComment() {
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));
        when(commentRepository.save(comment)).thenReturn(comment);
        when(commentMapper.toModel(comment)).thenReturn(commentModel);

        CommentModel result = commentService.update(commentId, commentModel);

        assertNotNull(result);
        assertEquals("Updated content", comment.getContent());
        verify(commentRepository).save(comment);
    }

    @Test
    @DisplayName("update - should throw when comment not found")
    void update_shouldThrowWhenCommentNotFound() {
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> commentService.update(commentId, commentModel));
    }

    @Test
    @DisplayName("update - should throw when user is not owner")
    void update_shouldThrowWhenUserNotOwner() {
        UUID otherUserId = UUID.randomUUID();

        commentModel = CommentModel.builder()
                .id(commentId)
                .content("Hack attempt")
                .userId(otherUserId)
                .cardId(cardId)
                .build();

        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        assertThrows(IllegalArgumentException.class,
                () -> commentService.update(commentId, commentModel));

        verify(commentRepository, never()).save(any());
    }

    @Test
    @DisplayName("delete - should delete comment successfully")
    void delete_shouldDeleteComment() {
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        commentService.delete(commentId);

        verify(commentRepository).delete(comment);
    }

    @Test
    @DisplayName("delete - should throw when comment not found")
    void delete_shouldThrowWhenCommentNotFound() {
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> commentService.delete(commentId));
    }
}
