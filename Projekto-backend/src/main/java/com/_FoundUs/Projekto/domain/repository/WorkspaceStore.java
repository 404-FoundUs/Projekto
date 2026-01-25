package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.WorkspaceModel;

import java.util.List;
import java.util.UUID;

public interface WorkspaceStore {
    WorkspaceModel createWorkspace(WorkspaceModel workspaceModel);
    List<WorkspaceModel> getUserWorkspaces(UUID userId);
    WorkspaceModel getById(UUID workspaceId);
    WorkspaceModel updateWorkspace(UUID id, WorkspaceModel workspaceModel);
    void deleteWorkspace(UUID id);
    void addMemberToWorkspace(UUID workspaceId, UUID userId);
    void removeMemberFromWorkspace(UUID workspaceId, UUID userId);
}
