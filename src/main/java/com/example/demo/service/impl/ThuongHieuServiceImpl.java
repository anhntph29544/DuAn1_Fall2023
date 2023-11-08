package com.example.demo.service.impl;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    ThuongHieuRepository thuongHieuRepository;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public Optional<ThuongHieu> detail(UUID id) {
        return thuongHieuRepository.findById(id);
    }

    @Override
    public Boolean add(ThuongHieu thuongHieu) {
        thuongHieuRepository.save(thuongHieu);
        return true;
    }

    @Override
    public Boolean delete(ThuongHieu thuongHieu) {
        thuongHieuRepository.delete(thuongHieu);
        return true;
    }

    @Override
    public Boolean update(ThuongHieu thuongHieu, UUID id) {
        thuongHieuRepository.save(thuongHieu);
        return true;
    }
}
