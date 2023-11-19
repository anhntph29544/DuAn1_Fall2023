package com.example.duan1.service;

import com.example.duan1.entity.SanPhamChiTiet;
import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamChiTietService {

    List<SanPhamChiTiet> getAll();

    Page<SanPhamChiTiet> getData(int page);

    List<SanPhamChiTiet> search(String ten, Integer trangThai);

    Page<SanPhamChiTiet> searchPage(String ten,Integer trangThai,int page);

    String tuTaoMa();

    Boolean save(SanPhamChiTiet spct);

    Boolean delete(UUID id);

    SanPhamChiTiet detail(UUID id);

}
