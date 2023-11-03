package com.example.duan1.service.impl;

import com.example.duan1.entity.KhungXe;
import com.example.duan1.repository.KhungXeRepository;
import com.example.duan1.service.KhungXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhungXeServiceImpl implements KhungXeService {

    @Autowired
    private KhungXeRepository kxr;

    @Override
    public List<KhungXe> getAll() {
        return kxr.findAll();
    }

    @Override
    public void save(KhungXe kx) {
        kxr.save(kx);
    }

    @Override
    public KhungXe detail(String id) {
        return kxr.findById(id).get();
    }

    @Override
    public void remove(String id) {
        kxr.deleteById(id);
    }
}
