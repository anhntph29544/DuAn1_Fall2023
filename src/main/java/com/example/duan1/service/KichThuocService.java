package com.example.duan1.service;

import com.example.duan1.entity.KichThuoc;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KichThuocService {

    List<KichThuoc> getAll();

    String tuTaoMa();

    Page<KichThuoc> getData(int page);

    List<KichThuoc> search(String ten);

    Page<KichThuoc> searchPage(String ten,int page);


    KichThuoc detail(UUID id);

    void save(KichThuoc kichThuoc);

    void delete(UUID id);

}
