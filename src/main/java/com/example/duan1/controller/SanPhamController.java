package com.example.duan1.controller;

import com.example.duan1.entity.SanPham;
import com.example.duan1.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService service;
    private List<SanPham> listSP= new ArrayList<>();

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model){
        listSP= service.getAll();
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", new SanPham());
        return "sanpham/sanphams";
    }

    @PostMapping("/san-pham/add")
    public String add(@Valid @ModelAttribute("sp1")SanPham sp1,
                      BindingResult result, Model model){
        service.save(sp1);
        return "redirect:/shop-xe/san-pham-chi-tiet/hien-thi";
    }

}
