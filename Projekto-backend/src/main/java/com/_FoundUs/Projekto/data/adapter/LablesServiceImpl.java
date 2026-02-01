package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.Board;
import com._FoundUs.Projekto.data.entity.Cards;
import com._FoundUs.Projekto.data.entity.Labels;
import com._FoundUs.Projekto.data.mapper.LablesMapper;
import com._FoundUs.Projekto.data.repository.BoardRepository;
import com._FoundUs.Projekto.data.repository.CardsRepository;
import com._FoundUs.Projekto.data.repository.LabelsRepository;
import com._FoundUs.Projekto.domain.model.LablesModel;
import com._FoundUs.Projekto.domain.repository.LablesStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LablesServiceImpl implements LablesStore {

    private final LabelsRepository labelsRepository;
    private final CardsRepository cardsRepository;
    private final BoardRepository boardRepository;

    private final LablesMapper mapper;

    @Override
    public LablesModel createLablesModel(LablesModel lablesModel) {
        Board board = boardRepository.findById(lablesModel.getBoardId()).orElseThrow(() -> new RuntimeException("Board not found"));

        if (labelsRepository.existsByBoardAndName(board, lablesModel.getName())) {
            throw new RuntimeException("Lables with name " + lablesModel.getName() + " already exists");
        }

        Labels labels = Labels.builder()
                .name(lablesModel.getName())
                .color(lablesModel.getColor())
                .board(board)
                .build();

        return mapper.toModel(labelsRepository.save(labels));
    }

    @Override
    public LablesModel updateLablesModel(UUID labelId, LablesModel lablesModel) {
        Labels labels = labelsRepository.findById(labelId).orElseThrow(() -> new RuntimeException("Label not found"));

        labels.setName(lablesModel.getName());
        labels.setColor(lablesModel.getColor());
        return mapper.toModel(labelsRepository.save(labels));
    }

    @Override
    public void deleteLablesModel(UUID lableId) {
        Labels labels = labelsRepository.findById(lableId).orElseThrow(() -> new RuntimeException("Label not found"));
        labelsRepository.delete(labels);
    }

    @Override
    public List<LablesModel> getLablesByBoard(UUID boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));

        return labelsRepository.findByBoard(board)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());

    }

    @Override
    public void assignToCard(UUID cardId, UUID labelId) {
        Cards card = cardsRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
        Labels labels = labelsRepository.findById(labelId).orElseThrow(() -> new RuntimeException("Label not found"));

        if (!card.getBoard().getId().equals(labels.getBoard().getId())) {
            throw new RuntimeException("Cannot assign label from another board");
        }

        card.getLabels().add(labels);
        cardsRepository.save(card);
    }

    @Override
    public void removeFromCard(UUID cardId, UUID labelId) {
        Cards card = cardsRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
        Labels labels = labelsRepository.findById(labelId).orElseThrow(() -> new RuntimeException("Label not found"));

        card.getLabels().remove(labels);
        cardsRepository.save(card);
    }
}
