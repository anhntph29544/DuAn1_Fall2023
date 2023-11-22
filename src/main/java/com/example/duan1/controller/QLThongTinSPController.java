package com.example.duan1.controller;

import com.example.duan1.entity.MauSac;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.ServiceResponse;
import com.example.duan1.service.KichThuocService;
import com.example.duan1.service.KieuDangXeService;
import com.example.duan1.service.MauSacSV;
import com.example.duan1.service.SanPhamService;
import com.example.duan1.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QLThongTinSPController {

    @Autowired
    private KichThuocService serviceKT;
    @Autowired
    private KieuDangXeService serviceKDX;
    @Autowired
    private MauSacSV serviceMS;
    @Autowired
    private SanPhamService serviceSP;
    @Autowired
    private ThuongHieuService serviceTH;

    @PostMapping("/shop-xe/san-pham-chi-tiet/sp/add")
    public ResponseEntity<Object> addSP(@RequestBody SanPham sp){
        serviceSP.save(sp);
        ServiceResponse<SanPham> response = new ServiceResponse<SanPham>("success",sp);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/sp/getAll")
    public ResponseEntity<Object> getAllSP(){
        ServiceResponse<SanPham> response = new ServiceResponse<SanPham>("success",serviceSP.getAll().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/ms/add")
    public ResponseEntity<Object> addMS(@RequestBody MauSac ms){
        serviceMS.save(ms);
        ServiceResponse<MauSac> response = new ServiceResponse<MauSac>("success",ms);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/ms/getAll")
    public ResponseEntity<Object> getAllMS(){
        ServiceResponse<MauSac> response = new ServiceResponse<MauSac>("success",serviceMS.getAll().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
