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

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping()
    public String form() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        // Tìm nhân viên theo email trong cơ sở dữ liệu
        NhanVien nhanVien = nhanVienRepository.findByEmail(username);

        // Kiểm tra nếu nhân viên tồn tại và mật khẩu khớp
        if (nhanVien != null && nhanVien.getMatKhau().equals(password)) {
            return "redirect:/nhan-vien/hien-thi";
        }

        // Nếu không khớp, quay lại trang đăng nhập
        return "index";
    }
}
