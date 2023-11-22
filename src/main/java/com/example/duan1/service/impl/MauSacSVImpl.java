package com.example.duan1.service.impl;

import com.example.duan1.entity.MauSac;
import com.example.duan1.repository.MauSacRepository;
import com.example.duan1.service.MauSacSV;
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
public class MauSacSVImpl implements MauSacSV {
    @Autowired
    private MauSacRepository repository;
    private String prefix= "MS";

    @Override
    public List<MauSac> getAll() {
        return repository.sort();
    }

    @Override
    public List<MauSac> getAllList() {
        return repository.sortList();
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= repository.maMS().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public Page<MauSac> getData(int page) {
        Pageable pageable= PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    @Override
    public List<MauSac> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public Page<MauSac> searchPage(String ten, int page) {
        List list= this.search(ten);
        Pageable pageable= PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<MauSac>(list, pageable, this.search(ten).size());
    }

    @Override
    public void save(MauSac p) {
        if(p.getMa()==null || p.getMa()==""){
            p.setMa(this.tuTaoMa());
        }
        if (p.getNgayThem()==null){
            p.setNgayThem(new java.util.Date());
        }
        repository.save(p);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public MauSac detail(UUID id) {
        return repository.findById(id).get();
    }
}
