package com.example.duan1.repository;

import com.example.duan1.entity.Phanh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhanhRepository extends JpaRepository<Phanh, UUID> {
}
