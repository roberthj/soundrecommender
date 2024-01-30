package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="credits")
public class Credit {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "id")
    private String id;

//    @Column(name="sound_id")
//    private String soundId;
    @ManyToOne
    private Sound sound;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role; //TODO: Consider using enum here
}
