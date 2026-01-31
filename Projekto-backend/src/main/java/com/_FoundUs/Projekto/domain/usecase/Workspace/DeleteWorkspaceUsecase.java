package com._FoundUs.Projekto.domain.usecase.Workspace;

import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteWorkspaceUsecase {
    private final WorkspaceStore workspaceStore;

    public void deleteWorkspace(UUID id) {
        workspaceStore.deleteWorkspace(id);
    }
}
