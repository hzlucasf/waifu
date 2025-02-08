package com.hzlucasf.waifu.service;

import com.hzlucasf.waifu.exception.WaifuNotFoundException;
import com.hzlucasf.waifu.model.Waifu;
import com.hzlucasf.waifu.repository.WaifuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaifuService {
    private final WaifuRepository waifuRepository;

    public WaifuService(WaifuRepository waifuRepository) {
        this.waifuRepository = waifuRepository;
    }

    public List<Waifu> findAll() {
        return waifuRepository.findAll();
    }

    public Waifu findById(UUID id) {
        var optionalWaifu = waifuRepository.findById(id);

        if (optionalWaifu.isEmpty()) {
            throw new WaifuNotFoundException("waifu not found");
        }

        return optionalWaifu.get();
    }
}
