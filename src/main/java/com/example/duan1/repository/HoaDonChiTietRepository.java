package com.example.duan1.repository;

import com.example.duan1.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {

    @Query("select hdct from HoaDonChiTiet hdct where hdct.hoaDon.id = ?1")
    public List<HoaDonChiTiet> getListHD(UUID id);

}
