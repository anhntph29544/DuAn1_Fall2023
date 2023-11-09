package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

//    @Override
//    public Boolean updateImageUrl(UUID id, String image) {
//        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(id);
//        if (optionalNhanVien.isPresent()) {
//            NhanVien nhanVien = optionalNhanVien.get();
//            nhanVien.setImage(image);
//            nhanVienRepository.save(nhanVien);
//            return true;
//        }
//        return false;
//    }

}
