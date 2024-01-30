package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    private Sound sound;

}
