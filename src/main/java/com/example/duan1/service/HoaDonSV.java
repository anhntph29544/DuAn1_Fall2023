package com.example.duan1.service;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonSV {
    List<HoaDon> getAll();

    Page<HoaDon> getData(int page);

    KhachHang Search(String email);
    HoaDon detail(UUID id);
List<HoaDon>getNgay();
    List<HoaDon> getCHT();

    void add(HoaDon hoaDon);
    String tuTaoMa();
}
