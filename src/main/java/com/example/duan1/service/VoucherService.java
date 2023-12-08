package com.example.duan1.service;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.Voucher;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface VoucherService {
    Page<Voucher> getDate(int page);
    List<Voucher> getAll();

    Page<Voucher> search(String ngayBD, String ngayKT,int page);

    void save(Voucher voucher);

    void delete(UUID id);

    Voucher detail(UUID id);
    List<Voucher> getHD();

}
