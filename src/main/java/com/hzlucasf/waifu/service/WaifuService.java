package com.hzlucasf.waifu.service;

import com.hzlucasf.waifu.repository.WaifuRepository;
import org.springframework.stereotype.Service;

@Service
public class WaifuService {
    private final WaifuRepository waifuRepository;

    public WaifuService(WaifuRepository waifuRepository) {
        this.waifuRepository = waifuRepository;
    }
}
