package com.example.duan1.service.impl;

import com.example.duan1.entity.NhanVien;
import com.example.duan1.repository.NhanVienRepository;
import com.example.duan1.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public List<NhanVien> findNhanVienByTrangThai(Integer trangThai) {
        return nhanVienRepository.findNhanVienByTrangThaiOrAll(trangThai);
    }

    @Override
    public Optional<NhanVien> detail(UUID id) {
        return nhanVienRepository.findById(id);
    }

    @Override
    public Boolean save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return true;
    }

    @Override
    public Boolean update(NhanVien nhanVien, UUID idNhanVien) {
        nhanVienRepository.save(nhanVien);
        return true;
    }

    @Override
    public Boolean delete(NhanVien nhanVien) {
        nhanVienRepository.delete(nhanVien);
        return true;
    }

    @Override
    public Boolean isEmailExists(String email) {
        return nhanVienRepository.existsByEmail(email);
    }


}
