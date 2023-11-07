package com.example.duan1.service.impl;

import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.repository.KieuDangXeRepository;
import com.example.duan1.service.KieuDangXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KieuDangXeServiceImpl implements KieuDangXeService {

    @Autowired
    private KieuDangXeRepository kdxr;

    @Override
    public Page<KieuDangXe> getData(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return kdxr.findAll(pageable);
    }

    @Override
    public List<KieuDangXe> getAll() {
        return kdxr.findAll();
    }

    @Override
    public void save(KieuDangXe kdx) {
        kdxr.save(kdx);
    }

    @Override
    public KieuDangXe detail(UUID id) {
        return kdxr.findById(id).get();
    }

    @Override
    public void remove(UUID id) {
        kdxr.deleteById(id);
    }

}
