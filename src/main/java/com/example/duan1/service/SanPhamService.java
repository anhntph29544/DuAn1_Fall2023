package com.example.duan1.service;

import com.example.duan1.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    void save(SanPham sp);

}
