package com.example.duan1.service.impl;

import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.repository.ThuongHieuRepository;
import com.example.duan1.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repository;

    @Override
    public Page<ThuongHieu> getData(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return repository.findAll(pageable);
    }

    @Override
    public List<ThuongHieu> getAll() {
        return repository.findAll();
    }

    @Override
    public ThuongHieu detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public Boolean save(ThuongHieu thuongHieu) {
        repository.save(thuongHieu);
        return null;
    }

    @Override
    public Boolean delete(ThuongHieu thuongHieu) {
        repository.deleteById(thuongHieu.getId());
        return null;
    }

}
