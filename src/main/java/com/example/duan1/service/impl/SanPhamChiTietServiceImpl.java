package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.repository.SanPhamChiTietRepository;
import com.example.duan1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    @Autowired
    private SanPhamChiTietRepository spctr;
    private String prefix= "SPCT";

    @Override
    public Page<SanPhamChiTiet> getAll(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return spctr.findAll(pageable);
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= spctr.maSPCT().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public Boolean save(SanPhamChiTiet spct) {
        spctr.save(spct);
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        spctr.deleteById(id);
        return null;
    }

    @Override
    public SanPhamChiTiet detail(UUID id) {
        return spctr.findById(id).get();
    }

}
