package com.example.duan1.service;

import com.example.duan1.entity.ThuongHieu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ThuongHieuService {

    List<ThuongHieu> getAll();

    Optional<ThuongHieu> detail(UUID id);

    Boolean add(ThuongHieu thuongHieu);

    Boolean delete(ThuongHieu thuongHieu);

    Boolean update(ThuongHieu thuongHieu);
}
