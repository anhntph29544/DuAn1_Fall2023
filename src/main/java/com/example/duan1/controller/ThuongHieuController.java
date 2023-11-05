package com.example.demo.controller;

import com.example.demo.model.HinhAnh;
import com.example.demo.model.ThuongHieu;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuService thuongHieuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<ThuongHieu> list = thuongHieuService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("thuongHieu", new ThuongHieu());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("hinhAnh") ThuongHieu thuongHieu){
        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }
}
