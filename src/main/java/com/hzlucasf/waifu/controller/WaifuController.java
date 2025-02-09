package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.model.Waifu;
import com.hzlucasf.waifu.service.WaifuService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PagedModel<EntityModel<Waifu>>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size
    ) {
        var pageable = (Pageable) PageRequest.of(page, size);

        var waifuPage = waifuService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(
                pagedResourcesAssembler.toModel(waifuPage)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Waifu> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(waifuService.findById(id));
    }
}
