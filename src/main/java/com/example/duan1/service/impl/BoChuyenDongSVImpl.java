package com.example.duan1.service.impl;

import com.example.duan1.entity.BoChuyenDong;
import com.example.duan1.repository.BoChuyenDongRepopsitory;
import com.example.duan1.service.BoChuyenDongSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class BoChuyenDongSVImpl implements BoChuyenDongSV {
    @Autowired
    private BoChuyenDongRepopsitory repopsitory;

    @Override
    public List<BoChuyenDong> getAll() {
        return repopsitory.findAll();
    }

    @Override
    public void add(BoChuyenDong p) {
        repopsitory.save(p);
    }

    @Override
    public void update(BoChuyenDong p, UUID id) {
        repopsitory.save(p);
    }

    @Override
    public BoChuyenDong detail(UUID id) {
        return repopsitory.findById(id).get();
    }
}