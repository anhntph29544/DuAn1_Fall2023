package com.example.duan1.repository;

import com.example.duan1.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, UUID> {

    @Query("select spct from SanPhamChiTiet spct where spct.sp.ten like %?1%")
    List<SanPhamChiTiet> search(String ten);

    @Query("select spct from SanPhamChiTiet spct where spct.trangThai = ?1")
    List<SanPhamChiTiet> search2(Integer trangThai);

    @Query("select spct from SanPhamChiTiet spct where spct.sp.ten like %?1% and spct.trangThai=?2")
    List<SanPhamChiTiet> search3(String ten,Integer trangThai);

    @Query("select spct.ma from SanPhamChiTiet spct")
    List<String> maSPCT();

}
