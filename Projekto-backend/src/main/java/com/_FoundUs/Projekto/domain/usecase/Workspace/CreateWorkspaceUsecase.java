package com._FoundUs.Projekto.domain.usecase.Workspace;

import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateWorkspaceUsecase {
    private final WorkspaceStore workspaceStore;

    public WorkspaceModel createWorkspace(WorkspaceModel workspaceModel) {
        return workspaceStore.createWorkspace(workspaceModel);
    }
}
