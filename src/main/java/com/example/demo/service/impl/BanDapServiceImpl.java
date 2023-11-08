package com.example.duan1.service.impl;

import com.example.duan1.entity.BanDap;
import com.example.duan1.repository.BanDapRepository;
import com.example.duan1.service.BanDapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BanDapServiceImpl implements BanDapService {

    @Autowired
    private BanDapRepository repository;

    @Override
    public List<BanDap> getAll() {
        return repository.findAll();
    }

    @Override
    public BanDap detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(BanDap bd) {
        repository.save(bd);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
