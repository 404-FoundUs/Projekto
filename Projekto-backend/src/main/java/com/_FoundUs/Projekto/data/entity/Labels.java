package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "labels",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"board_id", "name"})
        }
)
public class Labels {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 7)
    private String color;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    @ManyToMany(mappedBy = "labels")
    private List<Cards> cards;

}
