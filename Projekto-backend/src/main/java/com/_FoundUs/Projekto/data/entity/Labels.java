package com._FoundUs.Projekto.data.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.smartcardio.Card;
import java.util.HashSet;
import java.util.Set;
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
    private Board boardId;
    @ManyToMany(mappedBy = "labels")
    private Set<Cards> cards = new HashSet<>();

}
