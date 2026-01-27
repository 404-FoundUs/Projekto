package com._FoundUs.Projekto.domain.usecase.Workspace;


import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetUserWorkspacesUsecase {
    private final WorkspaceStore workspaceStore;

    public List<WorkspaceModel> getUserWorkspaces(UUID userId) {
        return workspaceStore.getUserWorkspaces(userId);
    }
}
