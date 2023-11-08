package com.example.demo.repository;

import com.example.demo.entity.KieuDangXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface KieuDangXeRepository extends JpaRepository<KieuDangXe,String> {
}
