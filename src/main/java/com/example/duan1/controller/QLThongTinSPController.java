package com.example.duan1.controller;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.entity.MauSac;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.ServiceResponse;
import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.service.KichThuocService;
import com.example.duan1.service.KieuDangXeService;
import com.example.duan1.service.MauSacSV;
import com.example.duan1.service.SanPhamService;
import com.example.duan1.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        ServiceResponse<SanPham> response = new ServiceResponse<SanPham>("success",serviceSP.getAllList().get(0));
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
        ServiceResponse<MauSac> response = new ServiceResponse<MauSac>("success",serviceMS.getAllList().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    //    Kiểu dáng xe
    @PostMapping("/shop-xe/san-pham-chi-tiet/kdx/add")
    public ResponseEntity<Object> addKDX(@RequestBody KieuDangXe kdx){
        serviceKDX.save(kdx);
        ServiceResponse<KieuDangXe> response = new ServiceResponse<KieuDangXe>("success",kdx);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/kdx/getAll")
    public ResponseEntity<Object> getAllKDX(){
        ServiceResponse<KieuDangXe> response = new ServiceResponse<KieuDangXe>("success",serviceKDX.getAllList().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    //    End kiểu dáng xe

    // Kích thước
    @PostMapping("/shop-xe/san-pham-chi-tiet/kt/add")
    public ResponseEntity<Object> addKT(@RequestBody KichThuoc kt){
        serviceKT.save(kt);
        ServiceResponse<KichThuoc> response = new ServiceResponse<KichThuoc>("success",kt);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/kt/getAll")
    public ResponseEntity<Object> getAllKT(){
        ServiceResponse<KichThuoc> response = new ServiceResponse<KichThuoc>("success",serviceKT.getAllList().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    // End kích thước

    //    Thương hiệu
    @PostMapping("/shop-xe/san-pham-chi-tiet/th/add")
    public ResponseEntity<Object> addTH(@RequestBody ThuongHieu th){
        serviceTH.save(th);
        ServiceResponse<ThuongHieu> response = new ServiceResponse<ThuongHieu>("success",th);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/th/getAll")
    public ResponseEntity<Object> getAllTH(){
        ServiceResponse<ThuongHieu> response = new ServiceResponse<ThuongHieu>("success",serviceTH.getAllList().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    //    End thương hiệu

}
