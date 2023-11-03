package com.example.duan1.service.impl;

import com.example.duan1.entity.GhiDong;
import com.example.duan1.repository.GhiDongRepository;
import com.example.duan1.service.GhiDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GhiDongServiceImpl implements GhiDongService {

    @Autowired
    private GhiDongRepository repository;

    @Override
    public List<GhiDong> getAll() {
        return repository.findAll();
    }

    @Override
    public GhiDong detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(GhiDong gd) {
        repository.save(gd);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
