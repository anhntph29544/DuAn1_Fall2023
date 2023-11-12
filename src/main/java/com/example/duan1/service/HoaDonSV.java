package com.example.duan1.service;

import com.example.duan1.entity.HoaDon;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonSV {
    List<HoaDon> getAll();

    Page<HoaDon> getData(int page);

    HoaDon detail(UUID id);

    void save(HoaDon hoaDon);
}
