package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "boards")
public class Board {

    private UUID id;
    private String name;
    private String description;
    private String visibility;
    private String workspaceId;


}
