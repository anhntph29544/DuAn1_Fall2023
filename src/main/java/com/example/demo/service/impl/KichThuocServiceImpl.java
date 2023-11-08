package com.example.duan1.service.impl;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.repository.KichThuocRepository;
import com.example.duan1.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    private KichThuocRepository repo;
    @Override
    public List<KichThuoc> getAll() {
        return repo.findAll();
    }

    @Override
    public void add(KichThuoc kichThuoc) {
        repo.save(kichThuoc);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public void update(KichThuoc kichThuoc, UUID id) {
        repo.save(kichThuoc);
    }

    @Override
    public KichThuoc detail(UUID id) {
        return repo.findById(id).get();
    }
}
