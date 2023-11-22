package com.example.duan1.service;

import com.example.duan1.entity.ThuongHieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {

    Page<ThuongHieu> getData(int page);

    String tuTaoMa();

    List<ThuongHieu> getAll();

    List<ThuongHieu> getAllList();

    ThuongHieu detail(UUID id);

    Boolean save(ThuongHieu thuongHieu);

    Boolean delete(ThuongHieu thuongHieu);

    List<ThuongHieu> search(String ten);

    Page<ThuongHieu> searchPage(String ten,int page);

}
