package com.example.duan1.repository;

import com.example.duan1.entity.KieuDangXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface KieuDangXeRepository extends JpaRepository<KieuDangXe,String> {
}
