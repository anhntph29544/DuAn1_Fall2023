package com.example.duan1.service;

import com.example.duan1.entity.Phanh;

import java.util.List;
import java.util.UUID;

public interface PhanhService {
    List<Phanh> getAll();

    void add(Phanh phanh);

    void delete(UUID id);

    void update(Phanh phanh, UUID id);

    Phanh detail(UUID id);
}
