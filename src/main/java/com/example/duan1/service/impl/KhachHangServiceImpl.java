package com.example.duan1.service.impl;

import com.example.duan1.entity.KhachHang;
import com.example.duan1.repository.KhachHangRepository;
import com.example.duan1.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public Optional<KhachHang> detail(UUID id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public Boolean add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
        return true;
    }

    @Override
    public Boolean delete(KhachHang khachHang) {
        khachHangRepository.delete(khachHang);
        return true;
    }

    @Override
    public Boolean update(KhachHang khachHang, UUID idKhachHang) {
        khachHangRepository.save(khachHang);
        return true;
    }

    @Override
    public List<KhachHang> findKhachHangByTrangThai(Integer trangThai) {
        return khachHangRepository.findKhachHangByTrangThaiOrAll(trangThai);
    }
}
