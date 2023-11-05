package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.repository.SanPhamChiTietRepository;
import com.example.duan1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    @Autowired
    private SanPhamChiTietRepository spctr;

    @Override
    public Page<SanPhamChiTiet> getAll(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return spctr.findAll(pageable);
    }
}
