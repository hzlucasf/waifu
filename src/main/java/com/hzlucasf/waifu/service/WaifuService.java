package com.hzlucasf.waifu.service;

import com.hzlucasf.waifu.model.Waifu;
import com.hzlucasf.waifu.repository.WaifuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaifuService {
    private final WaifuRepository waifuRepository;

    public WaifuService(WaifuRepository waifuRepository) {
        this.waifuRepository = waifuRepository;
    }

    public List<Waifu> findAll() {
        return waifuRepository.findAll();
    }
}
