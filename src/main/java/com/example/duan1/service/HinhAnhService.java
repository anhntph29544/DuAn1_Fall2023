package com.example.demo.service;

import com.example.demo.model.HinhAnh;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface HinhAnhService {
    List<HinhAnh> getAll();

    Optional<HinhAnh> detail(UUID id);

    Boolean add(HinhAnh hinhAnh);

    Boolean delete(HinhAnh hinhAnh);

    Boolean update(HinhAnh hinhAnh);
}
