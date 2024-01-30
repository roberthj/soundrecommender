package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="playlist_id")
    private List<PlaylistSound> soundIds;

}
