package com.example.duan1.service;

import com.example.duan1.entity.BoChuyenDong;

import java.util.List;
import java.util.UUID;

public interface BoChuyenDongSV {
    List<BoChuyenDong> getAll();

    void add(BoChuyenDong p);

    void update(BoChuyenDong p, UUID id);

    BoChuyenDong detail(UUID id);
}
