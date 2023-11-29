package com.example.duan1.service;

import com.example.duan1.entity.Voucher;

import java.util.List;
import java.util.UUID;

public interface VoucherService {
    List<Voucher> getAll();

    void add(Voucher voucher);

    void delete(UUID id);

    void update(Voucher voucher, UUID id);

    Voucher detail(UUID id);
}
