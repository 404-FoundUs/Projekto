package com._FoundUs.Projekto.domain.usecase.Workspace;

import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateWorkspaceUsecase {
    private final WorkspaceStore workspaceStore;

    public WorkspaceModel updateWorkspace(UUID id, WorkspaceModel workspaceModel) {
        return workspaceStore.updateWorkspace(id, workspaceModel);
    }
}
