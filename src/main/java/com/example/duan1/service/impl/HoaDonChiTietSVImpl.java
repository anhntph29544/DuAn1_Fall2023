package com.example.duan1.service.impl;

import com.example.duan1.entity.HoaDonChiTiet;
import com.example.duan1.repository.HoaDonChiTietRepository;
import com.example.duan1.repository.HoaDonRepository;
import com.example.duan1.service.HoaDonChiTietSV;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HoaDonChiTietSVImpl implements HoaDonChiTietSV {
    @Autowired
    private HoaDonChiTietRepository repository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return repository.findAll();
    }

    @Override
    public List<HoaDonChiTiet> getListHD(UUID idHD) {
        return repository.getListHD(idHD);
    }

    @Override
    public Page<HoaDonChiTiet> getData(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    @Override
    public HoaDonChiTiet detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(HoaDonChiTiet hoaDonChiTiet) {
        repository.save(hoaDonChiTiet);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
