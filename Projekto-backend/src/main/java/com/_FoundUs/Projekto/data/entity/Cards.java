package com._FoundUs.Projekto.data.entity;

import com._FoundUs.Projekto.domain.enums.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Integer position;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    private Lists list;
    @ManyToMany
    @JoinTable(
            name = "card_labels",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    @Builder.Default
    private Set<Labels> labels = new HashSet<>();
    @OneToMany(
            mappedBy = "card",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(
            mappedBy = "card",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Checklist> checklists = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @PrePersist
    protected  void createAt(){
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    protected  void updateAt(){
        this.updateAt = LocalDateTime.now();
    }
}
