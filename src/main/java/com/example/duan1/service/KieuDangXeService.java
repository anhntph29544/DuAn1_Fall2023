package com.example.duan1.service;

import com.example.duan1.entity.KieuDangXe;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KieuDangXeService {

    Page<KieuDangXe> getData(int page);

    String tuTaoMa();

    List<KieuDangXe> getAll();

    void save(KieuDangXe kdx);

    KieuDangXe detail(UUID id);

    void remove(UUID id);

    List<KieuDangXe> search(String ten);

    Page<KieuDangXe> searchPage(String ten,int page);

}
