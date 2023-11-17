package com.example.duan1.controller;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.service.HoaDonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonSV sv;
    private List<HoaDon> listHD = new ArrayList<>();

    @GetMapping("/hoa-don/hien-thi")
    public String hienThi(Model model) {
        listHD = sv.getCHT();
        model.addAttribute("listHD", listHD);
        model.addAttribute("hd", new HoaDon());
        return "/hoadon/hienThi";
    }
}
