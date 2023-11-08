package com.example.duan1.service;

import com.example.duan1.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface MauSacSV {
    List<MauSac> getAll();

    Page<MauSac> getData(int page);

    List<MauSac> search(String ten);

    Page<MauSac> searchPage(String ten,int page);

    void save(MauSac p);

    void delete(UUID id);

    MauSac detail(UUID id);
}
