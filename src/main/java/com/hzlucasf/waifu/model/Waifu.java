package com.hzlucasf.waifu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Waifu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "waifu_anime",
            joinColumns = @JoinColumn(name = "waifu_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id")
    )
    @JsonBackReference
    private Set<Anime> animes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(Set<Anime> animes) {
        this.animes = animes;
    }
}
