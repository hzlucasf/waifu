package com.hzlucasf.waifu.service;

import com.hzlucasf.waifu.exception.AnimeNotFoundException;
import com.hzlucasf.waifu.model.Anime;
import com.hzlucasf.waifu.repository.AnimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Page<Anime> findAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public Anime findById(UUID id) {
        var optionalAnime = animeRepository.findById(id);

        if (optionalAnime.isEmpty()) {
            throw new AnimeNotFoundException("anime not found");
        }

        return optionalAnime.get();
    }
}
