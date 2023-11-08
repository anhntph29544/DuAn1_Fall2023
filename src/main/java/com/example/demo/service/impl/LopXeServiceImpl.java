package com.example.duan1.service.impl;

import com.example.duan1.entity.LopXe;
import com.example.duan1.repository.LopXeRepository;
import com.example.duan1.service.LopXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LopXeServiceImpl implements LopXeService {

    @Autowired
    private LopXeRepository repository;

    @Override
    public List<LopXe> getAll() {
        return repository.findAll();
    }

    @Override
    public LopXe detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(LopXe lx) {
        repository.save(lx);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
