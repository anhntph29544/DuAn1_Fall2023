package com.example.duan1.service;

import com.example.duan1.entity.KieuDangXe;

import java.util.List;

public interface KieuDangXeService {

    List<KieuDangXe> getAll();

    void save(KieuDangXe kdx);

    KieuDangXe detail(String id);

    void remove(String id);

}
