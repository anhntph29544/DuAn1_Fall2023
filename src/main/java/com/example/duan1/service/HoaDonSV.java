package com.example.duan1.service;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface HoaDonSV {
    List<HoaDon> getAll();

    Page<HoaDon> getData(int page);

    KhachHang Search(String email);

    HoaDon detail(UUID id);

    List<HoaDon> findAllHD();

    KhachHang KHL();

    Page<HoaDon> getDataPT(int page);

    List<HoaDon> getNgay();

    List<HoaDon> getHUy();

    List<HoaDon> getDTT();

    List<HoaDon> getCHT();

    KhachHang layKHchoHD(UUID id);

    void add(HoaDon hoaDon);

    void delete(UUID id);

    String tuTaoMa();
}
