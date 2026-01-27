package com._FoundUs.Projekto.data.entity;

import com._FoundUs.Projekto.domain.enums.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Visibility visibility = Visibility.PUBLIC;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonBackReference
    private User owner;
    @ManyToMany
    @JoinTable(
            name = "workspace_users",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members = new ArrayList<>();
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void updatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

}
