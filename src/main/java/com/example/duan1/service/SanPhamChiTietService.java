package com.example.duan1.service;

import com.example.duan1.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;

public interface SanPhamChiTietService {

    Page<SanPhamChiTiet> getAll(int page);

}
