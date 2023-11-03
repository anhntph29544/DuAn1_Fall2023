package com.example.duan1.service;

import com.example.duan1.entity.KhungXe;

import java.util.List;

public interface KhungXeService {

    List<KhungXe> getAll();

    void save(KhungXe kx);

    KhungXe detail(String id);

    void remove(String id);


}
