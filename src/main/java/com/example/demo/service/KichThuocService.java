package com.example.demo.service;

import com.example.demo.entity.KichThuoc;

import java.util.List;
import java.util.UUID;

public interface KichThuocService {

    List<KichThuoc> getAll();

    void add(KichThuoc kichThuoc);

    void delete(UUID id);

    void update(KichThuoc kichThuoc, UUID id);

    KichThuoc detail(UUID id);

}
