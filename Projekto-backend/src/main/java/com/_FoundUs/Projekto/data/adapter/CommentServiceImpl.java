package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Comment;
import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.mapper.CommentMapper;
import com._FoundUs.Projekto.data.repository.CardsRepository;
import com._FoundUs.Projekto.data.repository.CommentRepository;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.domain.model.CommentModel;
import com._FoundUs.Projekto.domain.repository.CommentRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentRepo {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final CardsRepository cardsRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentModel save(CommentModel commentModel) {
        User user = userRepository.findById(commentModel.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found " + commentModel.getUserId()));
        Cards cards = cardsRepository.findById(commentModel.getCardId()).orElseThrow(() -> new EntityNotFoundException("Card not found " + commentModel.getCardId()));
        Comment commentEntity = commentMapper.toEntity(commentModel);
        commentEntity.setUser(user);
        commentEntity.setCard(cards);
        Comment saveEntity = commentRepository.save(commentEntity);
        return commentMapper.toModel(saveEntity);
    }

    @Override
    public CommentModel update(UUID id, CommentModel commentModel) {
        User user = userRepository.findById(commentModel.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found " + commentModel.getUserId()));
        Cards cards = cardsRepository.findById(commentModel.getCardId()).orElseThrow(() -> new EntityNotFoundException("Card not found " + commentModel.getCardId()));
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found " + id));

        if (!comment.getId().equals(commentModel.getId())) {
            comment.setContent(commentModel.getContent());
            comment.setUser(user);
            comment.setCard(cards);
            Comment saveComment = commentRepository.save(comment);
            return commentMapper.toModel(saveComment);
        }
        throw new IllegalArgumentException("You cannot update this comment");
    }

    @Override
    public void delete(UUID id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found " + id));
        commentRepository.delete(comment);
    }
}
