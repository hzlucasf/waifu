package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.model.Waifu;
import com.hzlucasf.waifu.service.WaifuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/waifus")
public class WaifuController {
    private final WaifuService waifuService;

    public WaifuController(WaifuService waifuService) {
        this.waifuService = waifuService;
    }

    @GetMapping
    public ResponseEntity<List<Waifu>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(waifuService.findAll());
    }
}
