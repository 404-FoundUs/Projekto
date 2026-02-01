package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.CardModel;
import com._FoundUs.Projekto.domain.usecase.Cards.*;
import com._FoundUs.Projekto.presentation.dto.Cards.CardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Cards.CardResponseDto;
import com._FoundUs.Projekto.presentation.dto.Cards.MoveCardRequestDto;
import com._FoundUs.Projekto.presentation.dto.Cards.ReorderCardsRequestDto;
import com._FoundUs.Projekto.presentation.mapper.CardApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CreateCardUsecase createCardUseCase;
    private final GetCardsByListIdUsecase getCardsByListUseCase;
    private final GetCardByIdUsecase getCardByIdUseCase;
    private final UpdateCardUsecase updateCardUseCase;
    private final DeleteCardByIdUsecase deleteCardUseCase;
    private final MoveCardUsecase moveCardUseCase;
    private final ReorderUsecase reorderCardsUseCase;

    private final CardApiMapper mapper;

    @PostMapping
    public ResponseEntity<CardResponseDto> create(
            @RequestBody CardRequestDto dto
    ) {
        CardModel model = createCardUseCase.createCard(mapper.toModel(dto));

        return ResponseEntity.ok(mapper.toResponse(model));
    }

    @GetMapping("/list/{listId}")
    public ResponseEntity<List<CardResponseDto>> getByList(
            @PathVariable UUID listId
    ) {
        List<CardResponseDto> responseDtos = getCardsByListUseCase.getCardsByListId(listId)
                .stream().map(mapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponseDto> getById(
            @PathVariable UUID cardId
    ) {
        CardModel cardModel = getCardByIdUseCase.getCardById(cardId);
        return ResponseEntity.ok(mapper.toResponse(cardModel));
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<CardResponseDto> update(
            @PathVariable UUID cardId,
            @RequestBody CardRequestDto dto
    ) {
        CardModel cardModel = updateCardUseCase.updateCard(cardId,mapper.toModel(dto));
        return ResponseEntity.ok(mapper.toResponse(cardModel));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID cardId
    ) {
        deleteCardUseCase.deleteCardById(cardId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{cardId}/move")
    public ResponseEntity<CardResponseDto> move(
            @PathVariable UUID cardId,
            @RequestBody MoveCardRequestDto dto
    ) {
        CardModel moved =
                moveCardUseCase.moveCard(cardId, dto.getTargetListId(), dto.getNewPosition());
        return ResponseEntity.ok(mapper.toResponse(moved));
    }

    @PatchMapping("/list/{listId}/reorder")
    public ResponseEntity<Void> reorder(
            @PathVariable UUID listId,
            @RequestBody ReorderCardsRequestDto dto
    ){
        reorderCardsUseCase.reorder(listId, dto.getOrderedCardIds());

        return ResponseEntity.ok().build();
    }
}
