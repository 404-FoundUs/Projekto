package com._FoundUs.Projekto.presentation.mapper;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.presentation.dto.Workspace.CreateWorkspaceRequestDto;
import com._FoundUs.Projekto.presentation.dto.Workspace.WorkspaceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface WorkspaceApiMapper {

    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "memberIds", expression = "java(mapMembersToIds(workspace.getMembers()))")
    WorkspaceModel toWorkspaceModel(Workspace workspace);


    default WorkspaceResponseDto toResponseDto(WorkspaceModel model) {
        return WorkspaceResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .visibility(model.getVisibility())
                .ownerId(model.getOwnerId())
                .memberIds(model.getMemberIds())
                .build();
    }

    default List<UUID> mapMembersToIds(List<User> members) {
        if (members == null) return List.of();
        return members.stream()
                .map(User::getId)
                .toList();
    }
}
