package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPham;
import com.example.duan1.repository.SanPhamRepository;
import com.example.duan1.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SanPham> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public Page<SanPham> searchPage(String ten, int page) {
        List list= this.search(ten);
        Pageable pageable= PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<SanPham>(list, pageable, this.search(ten).size());
    }

    @Override
    public Page<SanPham> getData(int page) {
        Pageable pageable= PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    @Override
    public SanPham detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(SanPham sp) {
        repository.save(sp);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
