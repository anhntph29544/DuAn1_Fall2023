package com.example.duan1.service;

import com.example.duan1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {
    Page<NhanVien> getAll(Pageable pageable);

    Optional<NhanVien> detail(UUID id);

    Boolean save(NhanVien nhanVien);

    Boolean update(NhanVien nhanVien, UUID idNhanVien);

    Boolean delete(NhanVien nhanVien);

}
