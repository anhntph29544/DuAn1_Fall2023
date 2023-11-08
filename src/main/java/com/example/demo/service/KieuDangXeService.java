package com.example.demo.service;

import com.example.demo.entity.KieuDangXe;

import java.util.List;

public interface KieuDangXeService {

    List<KieuDangXe> getAll();

    void save(KieuDangXe kdx);

    KieuDangXe detail(String id);

    void remove(String id);

}
