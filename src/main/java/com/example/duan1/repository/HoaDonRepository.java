package com.example.duan1.repository;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("Select hd from HoaDon hd where hd.tinhTrang=0 order by hd.ngayThem desc")
    public List<HoaDon> getChuaThanhToan();

    @Query("select hd from HoaDon hd where hd.khachHang.email = ?1 or hd.khachHang.sdt=?1")
    KhachHang search(String email);

    @Query("select hd from HoaDon hd order by hd.ngayThem desc ")
    List<HoaDon> getNgay();

    @Query("select hd.ma from HoaDon hd")
    List<String> maHD();
}