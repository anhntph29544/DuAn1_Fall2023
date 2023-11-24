package com.example.duan1.service.impl;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.repository.HoaDonRepository;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
    public KhachHang Search(String email) {
        return repository.search(email);
    }


    @Override
    public HoaDon detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public List<HoaDon> getNgay() {
        return repository.getNgay();
    }

    @Override
    public List<HoaDon> getCHT() {
        return repository.getChuaThanhToan();
    }

    @Override
    public void add(HoaDon hoaDon) {
        if (hoaDon.getMa() == null || hoaDon.getMa() == "") {
            hoaDon.setMa(this.tuTaoMa());
        }
        if (hoaDon.getNgayThem() == null) {
            hoaDon.setNgayThem(new java.util.Date());
        }
        repository.save(hoaDon);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private String prefix = "HD";

    @Override
    public String tuTaoMa() {
        Stream<String> ma = repository.maHD().stream();
        Integer max = ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix + (String.format("%d", max + 1));
    }


}
