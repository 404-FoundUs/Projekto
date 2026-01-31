package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface WorkspaceMapper {

    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "memberIds", expression = "java(mapMembersToIds(workspace.getMembers()))")
    WorkspaceModel toWorkspaceModel(Workspace workspace);

    default List<UUID> mapMembersToIds(List<User> members) {
        if (members == null) return List.of();
        return members.stream()
                .map(User::getId)
                .toList();
    }
}
