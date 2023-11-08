package com.example.demo.service;

import com.example.demo.entity.LopXe;

import java.util.List;
import java.util.UUID;

public interface LopXeService {

    List<LopXe> getAll();

    LopXe detail(UUID id);

    void save(LopXe lx);

    void delete(UUID id);

}
