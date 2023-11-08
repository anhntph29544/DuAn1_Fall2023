package com.example.demo.repository;

import com.example.demo.entity.KhungXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface KhungXeRepository extends JpaRepository<KhungXe,String> {
}
