package com.example.duan1.repository;

import com.example.duan1.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichThuocRepository extends JpaRepository<KichThuoc, UUID> {
}
