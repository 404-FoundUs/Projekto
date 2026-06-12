package com._FoundUs.Projekto.domain.usecase.Workspace;

import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RemoveMemberFromWorkspaceUsecase {

    private final WorkspaceStore workspaceStore;

    public void removeMemberFromWorkspace(UUID workspaceId, UUID userId) {
        workspaceStore.removeMemberFromWorkspace(workspaceId, userId);
    }

}
