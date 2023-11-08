package com.example.duan1.controller;

import com.example.duan1.entity.MauSac;

import com.example.duan1.service.MauSacSV;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/shop-xe")
public class MauSacController {
    @Autowired
    private MauSacSV sv;
    private Page<MauSac> listN;
    private UUID idMSCu;

    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "tenSearch",defaultValue = "") String ten, Model model) {
        listN = sv.getData(page);
        if(ten.trim() != ""){
            listN= sv.searchPage(ten.trim(), page);
            model.addAttribute("tenSearch", ten.trim());
        }
        model.addAttribute("listM", listN);
        model.addAttribute("m1", new MauSac());
        return "/mausac/MauSac";
    }

    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@RequestParam(value = "page", defaultValue = "0") int page,
                         @PathVariable("id") UUID id, Model model) {
        listN = sv.getData(page);
        MauSac ms= sv.detail(id);
        model.addAttribute("listM", listN);
        model.addAttribute("m1", ms);
        return "/mausac/MauSac";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        MauSac d = sv.detail(id);
        idMSCu=id;
        model.addAttribute("m1", d);
        return "/mausac/mausac-update";
    }

    @GetMapping("/mau-sac/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model) {
        sv.delete(id);
        return "redirect:/shop-xe/mau-sac/hien-thi";
    }


    @PostMapping("/mau-sac/add")
    public String add(@Valid @ModelAttribute("m1") MauSac n) {
        sv.save(n);
        return "redirect:/shop-xe/mau-sac/hien-thi";
    }

    @PostMapping("/mau-sac/update")
    public String update(@Valid @ModelAttribute("m1") MauSac p, BindingResult result) {
        p.setId(idMSCu);
        sv.save(p);
        return "redirect:/shop-xe/mau-sac/hien-thi";
    }

}
