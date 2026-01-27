package com._FoundUs.Projekto.data.mapper;

import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface WorkspaceMapper {
    WorkspaceModel toWorkspaceModel(Workspace workspace);
    Workspace toWorkspace(WorkspaceModel workspaceModel);
}
