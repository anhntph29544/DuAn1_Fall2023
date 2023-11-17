package com.example.duan1.repository;

import com.example.duan1.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("Select hd from HoaDon hd where hd.tinhTrang=0")
    public List<HoaDon> getChuaThanhToan();
}
