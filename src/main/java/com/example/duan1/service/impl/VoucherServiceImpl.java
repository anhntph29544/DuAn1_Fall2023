package com.example.duan1.service.impl;

import com.example.duan1.entity.Voucher;
import com.example.duan1.repository.VoucherRepository;
import com.example.duan1.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository repo;
    @Override
    public List<Voucher> getAll() {
        return repo.findAll();
    }

    @Override
    public void add(Voucher voucher) {
        repo.save(voucher);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Voucher voucher, UUID id) {
        repo.save(voucher);
    }

    @Override
    public Voucher detail(UUID id) {
        return repo.findById(id).get();
    }
}
