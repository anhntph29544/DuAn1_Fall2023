package com.example.demo.controller;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

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
        return "/thuonghieu/hien-thi";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("thuongHieu") ThuongHieu thuongHieu){
        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") ThuongHieu thuongHieu){
        thuongHieuService.delete(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        ThuongHieu thuongHieu = thuongHieuService.detail(id).get();
        model.addAttribute("object",thuongHieu);
        return "/thuonghieu/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute ThuongHieu thuongHieu){
        thuongHieuService.update(thuongHieu,id);
        return  "redirect:/thuong-hieu/hien-thi";
    }
}
