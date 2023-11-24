package com.example.duan1.repository;

import com.example.duan1.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query(value = "SELECT * FROM khach_hang WHERE trang_thai = ?1 OR ?1 IS NULL", nativeQuery = true)
    List<KhachHang> findKhachHangByTrangThaiOrAll(Integer trangThai);
}
