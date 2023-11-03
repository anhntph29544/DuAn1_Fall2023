package com.example.duan1.service.impl;

import com.example.duan1.entity.NSX;
import com.example.duan1.repository.NSXRepository;
import com.example.duan1.service.NSXSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NSXSVImpl implements NSXSV {
    @Autowired
    private NSXRepository repository;

    @Override
    public List<NSX> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(NSX p) {
        repository.save(p);
    }

    @Override
    public void update(NSX p, UUID id) {
        repository.save(p);
    }

    @Override
    public NSX detail(UUID id) {
        return repository.findById(id).get();
    }
}
