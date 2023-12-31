package com.example.duan1.repository;

import com.example.duan1.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {

    @Query("select sp from SanPham sp where sp.ten like %?1% order by sp.ngayThem desc")
    List<SanPham> search(String ten);

    @Query("select sp from SanPham sp where sp.trangThai = ?1 order by sp.ngayThem desc")
    List<SanPham> search2(Integer trangThai);

    @Query("select sp from SanPham sp where sp.ten like %?1% and sp.trangThai=?2 order by sp.ngayThem desc")
    List<SanPham> search3(String ten,Integer trangThai);

    @Query("select sp from SanPham sp where sp.trangThai=0 order by sp.ngayThem desc")
    List<SanPham> sort();

    @Query("select sp from SanPham sp order by sp.ngayThem desc")
    List<SanPham> sortList();

    @Query("select sp.ma from SanPham sp")
    List<String> maSP();

}
