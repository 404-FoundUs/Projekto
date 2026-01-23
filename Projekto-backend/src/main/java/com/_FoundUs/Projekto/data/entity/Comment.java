package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, columnDefinition = "TEXT", updatable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false, updatable = false)
    private Cards cardId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User userId;
    private LocalDateTime createdAt;

    @PrePersist
    protected void createAt(){
        this.createdAt = LocalDateTime.now();
    }



}
