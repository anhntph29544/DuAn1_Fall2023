package com.example.demo.service;

import com.example.demo.entity.BoChuyenDong;

import java.util.List;
import java.util.UUID;

public interface BoChuyenDongSV {
    List<BoChuyenDong> getAll();

    void add(BoChuyenDong p);

    void update(BoChuyenDong p, UUID id);

    BoChuyenDong detail(UUID id);
}
