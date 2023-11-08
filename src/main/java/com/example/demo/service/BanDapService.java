package com.example.demo.service;

import com.example.demo.entity.BanDap;

import java.util.List;
import java.util.UUID;

public interface BanDapService {

    List<BanDap> getAll();

    BanDap detail(UUID id);

    void save(BanDap bd);

    void delete(UUID id);

}
