package com.example.duan1.service.impl;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.repository.HoaDonRepository;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonSVImpl implements HoaDonSV {
    @Autowired
    private HoaDonRepository repository;

    @Override
    public List<HoaDon> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<HoaDon> getData(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }


    @Override
    public HoaDon detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public List<HoaDon> getCHT() {
        return repository.getChuaThanhToan();
    }

    @Override
    public void save(HoaDon hoaDon) {
        repository.save(hoaDon);
    }
}
