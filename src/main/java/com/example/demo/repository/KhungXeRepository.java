package com.example.duan1.repository;

import com.example.duan1.entity.KhungXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface KhungXeRepository extends JpaRepository<KhungXe,String> {
}
