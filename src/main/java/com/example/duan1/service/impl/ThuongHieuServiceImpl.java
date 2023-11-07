package com.example.duan1.service.impl;

import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.repository.ThuongHieuRepository;
import com.example.duan1.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repository;

    @Override
    public List<ThuongHieu> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ThuongHieu> detail(UUID id) {
        return Optional.empty();
    }

    @Override
    public Boolean add(ThuongHieu thuongHieu) {
        repository.save(thuongHieu);
        return null;
    }

    @Override
    public Boolean delete(ThuongHieu thuongHieu) {
        return null;
    }

    @Override
    public Boolean update(ThuongHieu thuongHieu) {
        repository.save(thuongHieu);
        return null;
    }
}
