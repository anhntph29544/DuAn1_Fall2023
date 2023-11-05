package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPham;
import com.example.duan1.repository.SanPhamRepository;
import com.example.duan1.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(SanPham sp) {
        repository.save(sp);
    }
}
