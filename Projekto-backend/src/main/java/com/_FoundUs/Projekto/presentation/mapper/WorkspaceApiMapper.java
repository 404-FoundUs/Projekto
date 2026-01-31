package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.presentation.dto.Workspace.CreateWorkspaceRequestDto;
import com._FoundUs.Projekto.presentation.dto.Workspace.UpdateWorkspaceRequestDto;
import com._FoundUs.Projekto.presentation.dto.Workspace.WorkspaceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkspaceApiMapper {

    default WorkspaceResponseDto toResponseDto(WorkspaceModel model) {
        if (model == null) return null;

        return WorkspaceResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .visibility(model.getVisibility())
                .ownerId(model.getOwnerId())
                .memberIds(model.getMemberIds() != null ? model.getMemberIds() : List.of())
                .build();
    }

    default WorkspaceModel toWorkspaceModel(CreateWorkspaceRequestDto dto, UUID ownerId) {
        if (dto == null) return null;

        return WorkspaceModel.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .visibility(dto.getVisibility())
                .ownerId(ownerId)
                .build();
    }

    default WorkspaceModel toWorkspaceModel(UpdateWorkspaceRequestDto dto, UUID ownerId) {
        if (dto == null) return null;

        return WorkspaceModel.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .visibility(dto.getVisibility())
                .ownerId(ownerId)
                .build();
    }

    default List<UUID> mapMembersToIds(List<User> members) {
        if (members == null) return List.of();
        return members.stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }
}
