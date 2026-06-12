package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.data.mapper.WorkspaceMapper;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.data.repository.WorkspaceRepository;
import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.domain.repository.WorkspaceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceStore {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper  workspaceMapper;
    private final UserRepository userRepository;

    @Override
    public WorkspaceModel createWorkspace(WorkspaceModel workspaceModel) {
        User user = userRepository.findById(workspaceModel.getOwnerId()).orElseThrow(()-> new RuntimeException("User not found"));

        Workspace workspace = Workspace.builder()
                .name(workspaceModel.getName())
                .description(workspaceModel.getDescription())
                .visibility(workspaceModel.getVisibility())
                .owner(user)
                .members(List.of(user))
                .build();

        return workspaceMapper.toWorkspaceModel(workspaceRepository.save(workspace));
    }

    @Override
    public List<WorkspaceModel> getUserWorkspaces(UUID userId) {
        return workspaceRepository.findByMembers_Id(userId)
                .stream()
                .map(workspaceMapper::toWorkspaceModel)
                .collect(Collectors.toList());
    }

    @Override
    public WorkspaceModel getWorkspaceById(UUID workspaceId) {
        return workspaceMapper.toWorkspaceModel(workspaceRepository.findById(workspaceId).orElseThrow(()-> new RuntimeException("Workspace not found")));
    }

    @Override
    public WorkspaceModel updateWorkspace(UUID id, WorkspaceModel workspaceModel) {
        Workspace workspace = workspaceRepository.findById(id).orElseThrow(()-> new RuntimeException("Workspace not found"));

        User owner = workspace.getOwner();

        if(!owner.getId().equals(workspaceModel.getOwnerId())) {
            throw new RuntimeException("User not owner of this workspace");
        }

        workspace.setName(workspaceModel.getName());
        workspace.setDescription(workspaceModel.getDescription());
        workspace.setVisibility(workspaceModel.getVisibility());

        return workspaceMapper.toWorkspaceModel(workspaceRepository.save(workspace));
    }

    @Override
    public void deleteWorkspace(UUID id) {
        Workspace workspace = workspaceRepository.findById(id).orElseThrow(()-> new RuntimeException("Workspace not found"));
        workspaceRepository.delete(workspace);
    }

    @Override
    public void addMemberToWorkspace(UUID workspaceId, UUID userId) {
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow(()-> new RuntimeException("Workspace not found"));
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));

        if (!workspace.getMembers().isEmpty()) {
            workspace.getMembers().add(user);
            workspaceRepository.save(workspace);
        }
    }

    @Override
    public void removeMemberFromWorkspace(UUID workspaceId, UUID userId) {
        Workspace workspace =workspaceRepository.findById(workspaceId).orElseThrow(()-> new RuntimeException("Workspace not found"));

        workspace.getMembers().removeIf(user -> user.getId().equals(userId));
        workspaceRepository.save(workspace);
    }
}
