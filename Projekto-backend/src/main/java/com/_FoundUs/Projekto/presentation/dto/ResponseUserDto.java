package com._FoundUs.Projekto.presentation.dto;

import com._FoundUs.Projekto.data.entity.Workspace;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseUserDto {
    private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private List<Workspace> workspaces = new ArrayList<>();
}
