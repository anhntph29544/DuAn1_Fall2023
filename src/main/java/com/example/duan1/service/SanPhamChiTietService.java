package com.example.duan1.service;

import com.example.duan1.entity.SanPhamChiTiet;
import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface SanPhamChiTietService {

    Page<SanPhamChiTiet> getAll(int page);

    Boolean save(SanPhamChiTiet spct);

    Boolean delete(UUID id);

    SanPhamChiTiet detail(UUID id);

}
