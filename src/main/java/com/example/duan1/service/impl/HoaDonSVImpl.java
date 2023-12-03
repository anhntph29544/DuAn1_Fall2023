package com.example.duan1.service.impl;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.entity.Voucher;
import com.example.duan1.repository.HoaDonRepository;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class HoaDonSVImpl implements HoaDonSV {
    @Autowired
    private HoaDonRepository repository;
    private List<HoaDon> listH = new ArrayList<>();

    @Override
    public List<HoaDon> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<HoaDon> getData(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    @Override
    public List<HoaDon> search(Date ngayBD, Date ngayKT, Integer trangThai) {
        if (ngayBD == null && ngayKT == null) {
            return repository.ttHD(trangThai);
        }
        if (trangThai == 3 && ngayBD != null && ngayKT!= null) {
            return repository.search(ngayBD, ngayKT);
        }
        return repository.search2(ngayBD, ngayKT, trangThai);
    }

    @Override
    public Page<HoaDon> search1(Date ngayBD, Date ngayKT, Integer trangThai, int page) {
        listH= this.search(ngayBD, ngayKT, trangThai);
        List list = this.search(ngayBD, ngayKT, trangThai);
        Pageable pageable = PageRequest.of(page, 5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<HoaDon>(list, pageable, this.search(ngayBD, ngayKT, trangThai).size());
    }

    @Override
    public KhachHang Search(String email) {
        return repository.search(email);
    }


    @Override
    public HoaDon detail(UUID id) {
        return repository.findById(id).get();
    }



    @Override
    public KhachHang KHL() {
        return repository.searchKHL();
    }

    @Override
    public Page<HoaDon> getDataPT(int page) {
        List list = repository.sortList();
        Pageable pageable = PageRequest.of(page, 5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<HoaDon>(list, pageable, repository.sortList().size());
    }

    @Override
    public List<HoaDon> getNgay() {
        return repository.getNgay();
    }

    @Override
    public List<HoaDon> getCHT() {
        return repository.CTT();
    }


    @Override
    public KhachHang layKHchoHD(UUID id) {
        return repository.chonKHchoHd(id);
    }

    @Override
    public Voucher layVCchoHD(UUID id) {
        return repository.chonVCchoHd(id);
    }

    @Override
    public List<HoaDon> getListHDDC(UUID id) {
        return repository.getListHDdc(id);
    }

    @Override
    public void add(HoaDon hoaDon) {
        if (hoaDon.getMa() == null || hoaDon.getMa() == "") {
            hoaDon.setMa(this.tuTaoMa());
        }
        if (hoaDon.getNgayThem() == null) {
            hoaDon.setNgayThem(new java.util.Date());
        }
        repository.save(hoaDon);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private String prefix = "HD";

    @Override
    public String tuTaoMa() {
        Stream<String> ma = repository.maHD().stream();
        Integer max = ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix + (String.format("%d", max + 1));
    }


}
