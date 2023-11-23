package com.example.duan1.controller;


import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.ResponseHoaDon;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QLHoaDon {
    @Autowired
    HoaDonSV hoaDonSV;

    @PostMapping("/hoa-don/add")
    public ResponseEntity<Object> add(@RequestBody HoaDon h) {
//        HoaDon h = new HoaDon();
//        h.setTinhTrang(0);

        hoaDonSV.add(h);
        ResponseHoaDon<HoaDon> responseHoaDon = new ResponseHoaDon<HoaDon>("success", h);
        return new ResponseEntity<Object>(responseHoaDon, HttpStatus.OK);
    }

    @GetMapping("/hoa-don/get")
    public ResponseEntity<Object> getHD(){
        ResponseHoaDon<HoaDon> response = new ResponseHoaDon<HoaDon>("success",hoaDonSV.getCHT().get(0));
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
