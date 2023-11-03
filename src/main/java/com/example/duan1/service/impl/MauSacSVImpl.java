package com.example.duan1.service.impl;

import com.example.duan1.entity.MauSac;
import com.example.duan1.repository.MauSacRepository;
import com.example.duan1.service.MauSacSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class MauSacSVImpl implements MauSacSV {
    @Autowired
    private MauSacRepository repository;

    @Override
    public List<MauSac> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(MauSac p) {
        repository.save(p);
    }

    @Override
    public void update(MauSac p, UUID id) {
        repository.save(p);
    }

    @Override
    public MauSac detail(UUID id) {
        return repository.findById(id).get();
    }
}
