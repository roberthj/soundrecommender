package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="playlists_sounds")
public class PlaylistSound {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Playlist playlist;

    @Column(name = "sound_id")
    private String soundId;

}
