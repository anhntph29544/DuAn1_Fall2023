package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.repository.SanPhamChiTietRepository;
import com.example.duan1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    @Autowired
    private SanPhamChiTietRepository spctr;
    private String prefix = "SPCT";
    private List<SanPhamChiTiet> listCT = new ArrayList<>();

    @Override
    public List<SanPhamChiTiet> getAll() {
        return spctr.spctHD();
    }

    @Override
    public Page<SanPhamChiTiet> getData(int page) {
        listCT = this.getAll();
        Pageable pageable = PageRequest.of(page, 5);
        return spctr.findAll(pageable);
    }

    @Override
    public List<SanPhamChiTiet> search(String ten, Integer trangThai) {
        if (ten.trim().isEmpty()) {
            return spctr.search2(trangThai);
        }
        if (trangThai == 3 && !ten.trim().isEmpty()) {
            return spctr.search(ten);
        }
        return spctr.search3(ten, trangThai);
    }

    @Override
    public Page<SanPhamChiTiet> searchPage(String ten, Integer trangThai, int page) {
        listCT = this.search(ten, trangThai);
        List list = this.search(ten, trangThai);
        Pageable pageable = PageRequest.of(page, 5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<SanPhamChiTiet>(list, pageable, this.search(ten, trangThai).size());
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma = spctr.maSPCT().stream();
        Integer max = ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix + (String.format("%d", max + 1));
    }

    @Override
    public Boolean save(SanPhamChiTiet spct) {
        try {
            spctr.save(spct);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    @Override
    public Page<SanPham> sortPage(Double min, Double max) {

        return null;
    }

}