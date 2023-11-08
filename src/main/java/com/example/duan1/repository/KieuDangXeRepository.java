package com.example.duan1.repository;

import com.example.duan1.entity.KieuDangXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public interface KieuDangXeRepository extends JpaRepository<KieuDangXe, UUID> {

    @Query("SELECT e FROM KieuDangXe e where e.ten like %?1%")
    List<KieuDangXe> search(String ten);

}
