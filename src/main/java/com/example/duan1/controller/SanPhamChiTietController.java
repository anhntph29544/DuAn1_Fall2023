package com.example.duan1.controller;

import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietService service;
    private Page<SanPhamChiTiet> listSPCT;

    @GetMapping("/san-pham-chi-tiet/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page, Model model){
        listSPCT= service.getAll(page);
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("spct1", new SanPhamChiTiet());
        return "/san-pham/hien-thi";
    }

}
