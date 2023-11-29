package com.example.duan1.service.impl;

import com.example.duan1.entity.ChucVu;
import com.example.duan1.repository.ChucVuRepository;
import com.example.duan1.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public Optional<ChucVu> detail(UUID id) {
        return chucVuRepository.findById(id);
    }

    @Override
    public Boolean add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
        return true;
    }

    @Override
    public Boolean update(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
        return true;
    }

    @Override
    public Boolean delete(ChucVu chucVu) {
        chucVuRepository.delete(chucVu);

        return true;
    }

}
