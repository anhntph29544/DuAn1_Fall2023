package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    Optional<ChucVu> detail(UUID id);

    Boolean add(ChucVu chucVu);

    Boolean update(ChucVu chucVu);

    Boolean delete(ChucVu chucVu);



}
