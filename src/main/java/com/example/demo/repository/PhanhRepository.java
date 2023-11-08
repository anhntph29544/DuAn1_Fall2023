package com.example.demo.repository;

import com.example.demo.entity.Phanh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhanhRepository extends JpaRepository<Phanh, UUID> {
}
