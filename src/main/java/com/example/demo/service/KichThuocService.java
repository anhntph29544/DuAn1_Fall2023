package com.example.duan1.service;

import com.example.duan1.entity.KichThuoc;

import java.util.List;
import java.util.UUID;

public interface KichThuocService {

    List<KichThuoc> getAll();

    void add(KichThuoc kichThuoc);

    void delete(UUID id);

    void update(KichThuoc kichThuoc, UUID id);

    KichThuoc detail(UUID id);

}
