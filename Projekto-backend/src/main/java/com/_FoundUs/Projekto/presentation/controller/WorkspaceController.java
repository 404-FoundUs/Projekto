package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.WorkspaceModel;
import com._FoundUs.Projekto.domain.usecase.Workspace.*;
import com._FoundUs.Projekto.presentation.dto.Workspace.CreateWorkspaceRequestDto;
import com._FoundUs.Projekto.presentation.dto.Workspace.UpdateWorkspaceRequestDto;
import com._FoundUs.Projekto.presentation.dto.Workspace.WorkspaceResponseDto;
import com._FoundUs.Projekto.presentation.mapper.WorkspaceApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {

    // 1st component creates after the initialization.
    private final AddMemberToWorkspaceUsecase addMemberToWorkspaceUsecase;
    private final CreateWorkspaceUsecase createWorkspaceUsecase;
    private final DeleteWorkspaceUsecase deleteWorkspaceUsecase;
    private final UpdateWorkspaceUsecase updateWorkspaceUsecase;
    private final GetUserWorkspacesUsecase getUserWorkspacesUsecase;
    private final GetWorkspaceByIdUsecase getWorkspaceByIdUsecase;
    private final RemoveMemberFromWorkspaceUsecase removeMemberFromWorkspaceUsecase;

    private final WorkspaceApiMapper workspaceApiMapper;

    @PostMapping
    public ResponseEntity<WorkspaceResponseDto> createWorkspace(
            @RequestBody CreateWorkspaceRequestDto requestDto) {
        WorkspaceModel workspaceModel = WorkspaceModel.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .visibility(requestDto.getVisibility())
                .ownerId(requestDto.getOwnerId())
                .build();

        WorkspaceModel saved =
                createWorkspaceUsecase.createWorkspace(workspaceModel);

        return ResponseEntity.ok(
                workspaceApiMapper.toResponseDto(saved)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkspaceResponseDto>> getUserWorkspace(@PathVariable UUID userId) {
        List<WorkspaceResponseDto> response = getUserWorkspacesUsecase.getUserWorkspaces(userId)
                .stream()
                .map(workspaceApiMapper::toResponseDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    /* this business logic not used so far ! */
    //    @GetMapping("/{workspaceId}")
//    public ResponseEntity<WorkspaceResponseDto> getWorkspaceById(@PathVariable UUID workspaceId) {
//        WorkspaceModel workspaceModel = getWorkspaceByIdUsecase.getWorkspaceById(workspaceId);
//        return ResponseEntity.ok(workspaceApiMapper.toResponseDto(workspaceModel));
//    }

    @PutMapping("/{workspaceId}")
    public ResponseEntity<WorkspaceResponseDto> updateWorkspace(
            @RequestBody UpdateWorkspaceRequestDto request,
            @PathVariable UUID workspaceId,
            @RequestParam UUID ownerId) {

        WorkspaceModel model = WorkspaceModel.builder()
                .name(request.getName())
                .description(request.getDescription())
                .visibility(request.getVisibility())
                .ownerId(ownerId)
                .build();

        WorkspaceModel updated = updateWorkspaceUsecase.updateWorkspace(workspaceId, model);
        return new ResponseEntity<>(workspaceApiMapper.toResponseDto(updated), HttpStatus.OK);
    }

    @DeleteMapping("/{workspaceId}")
    public ResponseEntity<Void> deleteWorkspace(
            @PathVariable UUID workspaceId
    ) {
        deleteWorkspaceUsecase.deleteWorkspace(workspaceId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{workspaceId}/members/{userId}")
    public ResponseEntity<WorkspaceResponseDto> addMemberToWorkspace(
            @PathVariable UUID workspaceId,
            @PathVariable UUID userId
    ) {
        addMemberToWorkspaceUsecase.addMemberToWorkspace(workspaceId, userId);

        WorkspaceModel updatedWorkspace =
                getWorkspaceByIdUsecase.getWorkspaceById(workspaceId);

        return ResponseEntity.ok(
                workspaceApiMapper.toResponseDto(updatedWorkspace)
        );
    }


    @DeleteMapping("/{workspaceId}/members/{userId}")
    public ResponseEntity<Void> removeMemberFromWorkspace(
            @PathVariable UUID workspaceId,
            @PathVariable UUID userId
    ) {
        removeMemberFromWorkspaceUsecase.removeMemberFromWorkspace(workspaceId, userId);
        return ResponseEntity.noContent().build();
    }
}
