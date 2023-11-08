package com.example.demo.service;

import com.example.demo.entity.KhungXe;

import java.util.List;

public interface KhungXeService {

    List<KhungXe> getAll();

    void save(KhungXe kx);

    KhungXe detail(String id);

    void remove(String id);


}
