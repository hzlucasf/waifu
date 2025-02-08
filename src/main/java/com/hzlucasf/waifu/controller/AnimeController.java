package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.model.Anime;
import com.hzlucasf.waifu.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public ResponseEntity<List<Anime>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(animeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(animeService.findById(id));
    }
}
