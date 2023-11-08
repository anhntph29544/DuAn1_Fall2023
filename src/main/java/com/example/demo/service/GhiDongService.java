package com.example.duan1.service;

import com.example.duan1.entity.GhiDong;

import java.util.List;
import java.util.UUID;

public interface GhiDongService {

    List<GhiDong> getAll();

    GhiDong detail(UUID id);

    void save(GhiDong gd);

    void delete(UUID id);

}
