package com.example.duan1.repository;

import com.example.duan1.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "SELECT * FROM nhan_vien WHERE trang_thai = ?1 OR ?1 IS NULL", nativeQuery = true)
    List<NhanVien> findNhanVienByTrangThaiOrAll(Integer trangThai);
    NhanVien findByEmail(String email);
    Boolean existsByEmail(String email);

}
