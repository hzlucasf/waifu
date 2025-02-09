package com.hzlucasf.waifu.repository;

import com.hzlucasf.waifu.model.Waifu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WaifuRepository extends JpaRepository<Waifu, UUID> {
    @Override
    @NonNull
    Page<Waifu> findAll(@NonNull Pageable pageable);
}
