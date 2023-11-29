package com.example.duan1.service;

import com.example.duan1.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietSV {
    List<HoaDonChiTiet> getAll();

    List<HoaDonChiTiet> getListHD(UUID idHD);

    Page<HoaDonChiTiet> getData(int page);

    HoaDonChiTiet detail(UUID id);

    void save(HoaDonChiTiet hoaDonChiTiet);

    void delete(UUID id);
}
