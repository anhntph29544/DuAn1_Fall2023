package com.example.duan1.service.impl;

import com.example.duan1.entity.Voucher;
import com.example.duan1.repository.VoucherRepository;
import com.example.duan1.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository repo;
    private List<Voucher> list = new ArrayList<>();

    @Override
    public Page<Voucher> getDate(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }

    @Override
    public Page<Voucher> search(Date ngayBD, Date ngayKT,int page) {
        for (Voucher vc : repo.findAll()) {
            if (vc.getNgayBD().after(ngayBD) && vc.getNgayBD().before(ngayKT) ||
                    vc.getNgayKT().after(ngayBD) && vc.getNgayKT().before(ngayKT)) {
                list.add(vc);
                break;
            }
        }
        int pageSize = 5;
        int start = page * pageSize;
        int end = Math.min((page + 1) * pageSize, list.size());
        List<Voucher> sublist = list.subList(start, end);
        return new PageImpl<>(sublist, PageRequest.of(page, pageSize), list.size());
    }

    @Override
    public void save(Voucher voucher) {
        repo.save(voucher);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Voucher detail(UUID id) {
        return repo.findById(id).get();
    }
}
