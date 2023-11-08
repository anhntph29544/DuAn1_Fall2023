package com.example.duan1.controller;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class KichThuocController {
    @Autowired
    private KichThuocService service;

    @GetMapping("/kich-thuoc/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list",service.getAll());
        return "/kichthuoc/kichthuoc";
    }

    @GetMapping("/kich-thuoc/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        KichThuoc kt=service.detail(id);
        model.addAttribute("kt",kt);
        model.addAttribute("list",service.getAll());
        return "/kichthuoc/kichthuoc";
    }
    @PostMapping("/kich-thuoc/add")
    public String add( @ModelAttribute("kt") KichThuoc kt) {
        service.add(kt);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("/kich-thuoc/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        KichThuoc kt=service.detail(id);
        model.addAttribute("kt",kt);
        return "/kichthuoc/kichthuoc-update";
    }

    @PostMapping("/kich-thuoc/update/{id}")
    public String update(@PathVariable("id") UUID id,  @ModelAttribute("kt") KichThuoc kt, BindingResult result) {
        service.update(kt, id);
        return "redirect:/kich-thuoc/hien-thi";
    }
    @GetMapping("/kich-thuoc/delete/{id}")
    public String remove(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/kich-thuoc/hien-thi";
    }
}
