package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lists {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    private Integer position;
    @OneToMany(
            mappedBy = "list",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    @OrderBy("position ASC")
    private List<Cards> cards = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board boardId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


    @PrePersist
    public void createAt() {
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updateAt() {
        this.updateAt = LocalDateTime.now();
    }

}
