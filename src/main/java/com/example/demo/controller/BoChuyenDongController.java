package com.example.demo.controller;

import com.example.demo.entity.BoChuyenDong;
import com.example.demo.entity.MauSac;
import com.example.demo.service.BoChuyenDongSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BoChuyenDongController {
    @Autowired
    private BoChuyenDongSV sv;
    private List<BoChuyenDong> listN=new ArrayList<>();
    @GetMapping("/bo-chuyen-dong/hien-thi")
    public String hienThi(Model model){
        listN=sv.getAll();
        model.addAttribute("listM",listN);
        model.addAttribute("m1", new MauSac());
        return "/bochuyendong/BoChuyenDong";
    }
    @GetMapping("/bo-chuyen-dong/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        BoChuyenDong n = sv.detail(id);
        listN = sv.getAll();
        model.addAttribute("listM", listN);
        model.addAttribute("m1", n);
        return "/bochuyendong/BoChuyenDong";
    }
    @PostMapping("/bo-chuyen-dong/add")
    public String add( @ModelAttribute("m1") BoChuyenDong n) {
        sv.add(n);
        return "redirect:/bo-chuyen-dong/hien-thi";
    }

    @GetMapping("/bo-chuyen-dong/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        BoChuyenDong d = sv.detail(id);
        model.addAttribute("m1", d);
        return "/bo-chuyen-dong/bo-chuyen-dong-update";
    }

    @PostMapping("/bo-chuyen-dong/update/{id}")
    public String update(@PathVariable("id") UUID id, @ModelAttribute("m1") BoChuyenDong p, BindingResult result) {

        sv.update(p, id);
        return "redirect:/bo-chuyen-dong/hien-thi";
    }
}
