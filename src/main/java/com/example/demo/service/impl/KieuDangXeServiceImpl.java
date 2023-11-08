package com.example.demo.service.impl;

import com.example.demo.entity.KieuDangXe;
import com.example.demo.repository.KieuDangXeRepository;
import com.example.demo.service.KieuDangXeService;
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
