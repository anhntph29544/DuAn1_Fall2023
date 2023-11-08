package com.example.duan1.repository;

import com.example.duan1.entity.BoChuyenDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BoChuyenDongRepopsitory extends JpaRepository<BoChuyenDong, UUID> {
}
