package com.example.duan1.service;

import com.example.duan1.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    List<SanPham> search(String ten,Integer trangThai);

    Page<SanPham> searchPage(String ten,Integer trangThai,int page);

    Page<SanPham> getData(int page);

    SanPham detail(UUID id);

    void save(SanPham sp);

    void delete(UUID id);

}
