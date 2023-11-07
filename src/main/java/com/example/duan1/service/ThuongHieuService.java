package com.example.duan1.service;

import com.example.duan1.entity.ThuongHieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ThuongHieuService {

    Page<ThuongHieu> getData(int page);

    List<ThuongHieu> getAll();

    ThuongHieu detail(UUID id);

    Boolean save(ThuongHieu thuongHieu);

    Boolean delete(ThuongHieu thuongHieu);

}
