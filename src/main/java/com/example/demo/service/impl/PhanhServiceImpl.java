package com.example.duan1.service.impl;

import com.example.duan1.entity.Phanh;
import com.example.duan1.repository.PhanhRepository;
import com.example.duan1.service.PhanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PhanhServiceImpl implements PhanhService {
    @Autowired
    private PhanhRepository repo;
    @Override
    public List<Phanh> getAll() {
        return repo.findAll();
    }

    @Override
    public void add(Phanh phanh) {
        repo.save(phanh);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Phanh phanh, UUID id) {
        repo.save(phanh);
    }

    @Override
    public Phanh detail(UUID id) {
        return repo.findById(id).get();
    }
}
