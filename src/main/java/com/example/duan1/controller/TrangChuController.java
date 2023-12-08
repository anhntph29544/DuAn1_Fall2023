package com.example.duan1.controller;

import com.example.duan1.entity.NhanVien;
import com.example.duan1.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop-xe")
public class TrangChuController {

    public static NhanVien nvDN;
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping()
    public String form() {
        return "index";
    }
    @GetMapping("/trang-chu")
    public String hienThi() {
        return "trangchu/hien-thi";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        NhanVien nhanVien = nhanVienRepository.findByEmail(username);

        if (nhanVien != null && nhanVien.getMatKhau().equals(password)) {
            nvDN= nhanVien;
            return "redirect:/shop-xe/trang-chu";
        }
        return "index";
    }
}
