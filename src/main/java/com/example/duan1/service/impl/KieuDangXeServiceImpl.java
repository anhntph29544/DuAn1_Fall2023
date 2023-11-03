package com.example.duan1.service.impl;

import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.repository.KieuDangXeRepository;
import com.example.duan1.service.KieuDangXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KieuDangXeServiceImpl implements KieuDangXeService {

    @Autowired
    private KieuDangXeRepository kdxr;

    @Override
    public List<KieuDangXe> getAll() {
        return kdxr.findAll();
    }

    @Override
    public void save(KieuDangXe kdx) {
        kdxr.save(kdx);
    }

    @Override
    public KieuDangXe detail(String id) {
        return kdxr.findById(id).get();
    }

    @Override
    public void remove(String id) {
        kdxr.deleteById(id);
    }

}
