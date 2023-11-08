package com.example.duan1.service;

import com.example.duan1.entity.BanDap;

import java.util.List;
import java.util.UUID;

public interface BanDapService {

    List<BanDap> getAll();

    BanDap detail(UUID id);

    void save(BanDap bd);

    void delete(UUID id);

}
