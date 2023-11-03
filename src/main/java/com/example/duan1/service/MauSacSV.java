package com.example.duan1.service;

import com.example.duan1.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacSV {
    List<MauSac> getAll();

    void add(MauSac p);

    void update(MauSac p, UUID id);

    MauSac detail(UUID id);
}
