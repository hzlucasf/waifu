package com.hzlucasf.waifu.service;

import com.hzlucasf.waifu.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }
}
