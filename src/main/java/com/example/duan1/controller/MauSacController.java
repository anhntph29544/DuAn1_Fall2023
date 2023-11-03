package com.example.duan1.controller;

import com.example.duan1.entity.MauSac;

import com.example.duan1.service.MauSacSV;
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
public class MauSacController {
    @Autowired
    private MauSacSV sv;
    private List<MauSac> listN=new ArrayList<>();
    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(Model model){
        listN=sv.getAll();
        model.addAttribute("listM",listN);
        model.addAttribute("m1", new MauSac());
        return "MauSac";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        MauSac n = sv.detail(id);
        listN = sv.getAll();
        model.addAttribute("listM", listN);
        model.addAttribute("m1", n);
        return "MauSac";
    }
    @PostMapping("/mau-sac/add")
    public String add( @ModelAttribute("m1") MauSac n) {
        sv.add(n);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        MauSac d = sv.detail(id);
        model.addAttribute("m1", d);
        return "mausac-update";
    }

    @PostMapping("/mau-sac/update/{id}")
    public String update(@PathVariable("id") UUID id,  @ModelAttribute("m1") MauSac p, BindingResult result) {

        sv.update(p, id);
        return "redirect:/mau-sac/hien-thi";
    }
}
