package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String visibility;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspaceId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Card> lists = new ArrayList<>();

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Label> labels = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void createAt(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void updateAt(){
        this.updatedAt = LocalDateTime.now();
    }

}
