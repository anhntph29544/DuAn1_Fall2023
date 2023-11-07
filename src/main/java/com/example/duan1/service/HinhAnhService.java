package com.example.duan1.service;

import com.example.duan1.entity.HinhAnh;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HinhAnhService {

    List<HinhAnh> getAll();

    Optional<HinhAnh> detail(UUID id);

    Boolean add(HinhAnh hinhAnh);

    Boolean delete(HinhAnh hinhAnh);

    Boolean update(HinhAnh hinhAnh);
}
