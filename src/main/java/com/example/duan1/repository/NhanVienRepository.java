package com.example.duan1.repository;

import com.example.duan1.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    NhanVien findByEmail(String email);
    Boolean existsByEmail(String email);
}
