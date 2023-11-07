package com.example.duan1.service.impl;

import com.example.duan1.entity.HinhAnh;
import com.example.duan1.repository.HinhAnhRepository;
import com.example.duan1.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {

    @Autowired
    private HinhAnhRepository repository;

    @Override
    public List<HinhAnh> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<HinhAnh> detail(UUID id) {
        return Optional.empty();
    }

    @Override
    public Boolean add(HinhAnh hinhAnh) {
        repository.save(hinhAnh);
        return null;
    }

    @Override
    public Boolean delete(HinhAnh hinhAnh) {
        return null;
    }

    @Override
    public Boolean update(HinhAnh hinhAnh) {
        repository.save(hinhAnh);
        return null;
    }
}
