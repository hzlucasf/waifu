package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.model.Anime;
import com.hzlucasf.waifu.service.AnimeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    private final AnimeService animeService;

    private final PagedResourcesAssembler<Anime> pagedResourcesAssembler;

    public AnimeController(AnimeService animeService, PagedResourcesAssembler<Anime> pagedResourcesAssembler) {
        this.animeService = animeService;

        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<Anime>>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size
    ) {
        var pageable = (Pageable) PageRequest.of(page, size);

        var animePage = animeService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(
                pagedResourcesAssembler.toModel(animePage)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(animeService.findById(id));
    }
}
