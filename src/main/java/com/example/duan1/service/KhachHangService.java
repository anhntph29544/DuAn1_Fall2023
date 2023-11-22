package com.example.duan1.service;

import com.example.duan1.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {
     Page<KhachHang> getAll(Pageable pageable);

     Optional<KhachHang> detail(UUID id);

     Boolean add(KhachHang khachHang);

    Boolean delete(KhachHang khachHang);

    Boolean update(KhachHang khachHang, UUID idKhachHang);

    List<KhachHang> findKhachHangByTrangThai(Integer trangThai);
}
