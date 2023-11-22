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

    @Query("select kdx from KieuDangXe kdx where kdx.trangThai=0 order by kdx.ngayThem desc")
    List<KieuDangXe> sort();

    @Query("select kdx from KieuDangXe kdx order by kdx.ngayThem desc")
    List<KieuDangXe> sortList();

    @Query("select kdx.ma from KieuDangXe kdx")
    List<String> maKDX();

}
