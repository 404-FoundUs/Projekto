package com._FoundUs.Projekto.domain.model;

import com._FoundUs.Projekto.data.entity.Workspace;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserModel {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private List<Workspace> workspaces = new ArrayList<>();
}
