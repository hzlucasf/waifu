package com.hzlucasf.waifu.repository;

import com.hzlucasf.waifu.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID> {
}
