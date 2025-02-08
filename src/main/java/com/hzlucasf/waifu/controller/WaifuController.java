package com.hzlucasf.waifu.controller;

import com.hzlucasf.waifu.service.WaifuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/waifus")
public class WaifuController {
    private final WaifuService waifuService;

    public WaifuController(WaifuService waifuService) {
        this.waifuService = waifuService;
    }
}
