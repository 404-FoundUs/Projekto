package com._FoundUs.Projekto.presentation.dto;

import com._FoundUs.Projekto.data.entity.Workspace;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestUserDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private List<Workspace> workspaces = new ArrayList<>();
}
