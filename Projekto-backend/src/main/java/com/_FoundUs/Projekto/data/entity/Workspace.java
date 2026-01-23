package com._FoundUs.Projekto.data.entity;

import com._FoundUs.Projekto.domain.enums.Visibility;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

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
    private User owner;
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
