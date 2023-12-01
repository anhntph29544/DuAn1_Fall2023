package com.example.duan1.service;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.HoaDonChiTiet;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.entity.Voucher;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface HoaDonSV {

    List<HoaDon> getAll();

    Page<HoaDon> getData(int page);

    List<HoaDon> search(Date ngayBD, Date ngayKT, Integer trangThai);

    Page<HoaDon> search1(Date ngayBD, Date ngayKT, Integer trangThai, int page);

    KhachHang Search(String email);

    HoaDon detail(UUID id);

    List<HoaDon> findAllHD();

    KhachHang KHL();

    Page<HoaDon> getDataPT(int page);

    List<HoaDon> getNgay();
List<HoaDon>getCHT();

    KhachHang layKHchoHD(UUID id);

    Voucher layVCchoHD(UUID id);

    List<HoaDon> getListHDDC(UUID id);

    void add(HoaDon hoaDon);

    void delete(UUID id);

    String tuTaoMa();
}
