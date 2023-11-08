package com.example.demo.service.impl;

import com.example.demo.entity.HinhAnh;
import com.example.demo.repository.HinhAnhRepository;
import com.example.demo.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {
    @Autowired
    HinhAnhRepository hinhAnhRepository;
    @Override
    public List<HinhAnh> getAll() {
        return hinhAnhRepository.findAll();
    }

    @Override
    public Optional<HinhAnh> detail(UUID id) {
        return hinhAnhRepository.findById(id);
    }

    @Override
    public Boolean add(HinhAnh hinhAnh) {
        hinhAnhRepository.save(hinhAnh);
        return true;
    }

    @Override
    public Boolean delete(HinhAnh hinhAnh) {
        hinhAnhRepository.delete(hinhAnh);
        return true;
    }

    @Override
    public Boolean update(HinhAnh hinhAnh, UUID id) {
        hinhAnhRepository.save(hinhAnh);
        return true;
    }
}
