package com.example.demo.service.impl;

import com.example.demo.entity.BanDap;
import com.example.demo.repository.BanDapRepository;
import com.example.demo.service.BanDapService;
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
