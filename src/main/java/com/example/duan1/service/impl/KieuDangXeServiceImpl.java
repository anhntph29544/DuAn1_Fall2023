package com.example.duan1.service.impl;

import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.repository.KieuDangXeRepository;
import com.example.duan1.service.KieuDangXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class KieuDangXeServiceImpl implements KieuDangXeService {

    @Autowired
    private KieuDangXeRepository kdxr;
    private String prefix="KDX";

    @Override
    public Page<KieuDangXe> getData(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return kdxr.findAll(pageable);
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= kdxr.maKDX().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public List<KieuDangXe> getAll() {
        return kdxr.sort();
    }

    @Override
    public List<KieuDangXe> getAllList() {
        return kdxr.sortList();
    }

    @Override
    public void save(KieuDangXe kdx) {
        if(kdx.getMa()==null || kdx.getMa().trim()==""){
            kdx.setMa(this.tuTaoMa());
        }
        if (kdx.getNgayThem()==null){
            kdx.setNgayThem(new java.util.Date());
        }
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

    @Override
    public List<KieuDangXe> search(String ten) {
        return kdxr.search(ten);
    }

    @Override
    public Page<KieuDangXe> searchPage(String ten, int page) {
        List<KieuDangXe> list = this.search(ten);
        Pageable pageable = PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<>(list, pageable, this.search(ten).size());
    }

}
