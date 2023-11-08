package com.example.duan1.service;

import com.example.duan1.entity.LopXe;

import java.util.List;
import java.util.UUID;

public interface LopXeService {

    List<LopXe> getAll();

    LopXe detail(UUID id);

    void save(LopXe lx);

    void delete(UUID id);

}
