package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.model.Waifu;
import com.hzlucasf.waifu.service.WaifuService;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/waifus")
public class WaifuController {
    private final WaifuService waifuService;

    private final PagedResourcesAssembler<Waifu> pagedResourcesAssembler;

    public WaifuController(WaifuService waifuService, PagedResourcesAssembler<Waifu> pagedResourcesAssembler) {
        this.waifuService = waifuService;

        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public ResponseEntity<List<Waifu>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(waifuService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Waifu> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(waifuService.findById(id));
    }
}
