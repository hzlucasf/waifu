package com.hzlucasf.waifu.repository;

import com.hzlucasf.waifu.model.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    @Override
    @NonNull
    Page<Anime> findAll(@NonNull Pageable pageable);
}
