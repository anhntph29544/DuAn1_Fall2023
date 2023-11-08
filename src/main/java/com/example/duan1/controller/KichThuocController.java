package com.example.duan1.controller;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.service.KichThuocService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class KichThuocController {

    @Autowired
    private KichThuocService service;
    private Page<KichThuoc> listKT;
    private UUID idKTCu;

    @GetMapping("/shop-xe/kich-thuoc/hien-thi")
    public String hienthi(@RequestParam(value = "page", defaultValue = "0")int page,
                          @RequestParam(value = "tenSearch",defaultValue = "") String ten, Model model) {
        listKT= service.getData(page);
        if(ten.trim() != ""){
            listKT= service.searchPage(ten.trim(), page);
            model.addAttribute("tenSearch", ten.trim());
        }
        model.addAttribute("listKT", listKT);
        model.addAttribute("kt1", new KichThuoc());
        return "/kichthuoc/kichthuoc";
    }

    @GetMapping("/shop-xe/kich-thuoc/detail/{id}")
    public String detail(@RequestParam(value = "page", defaultValue = "0")int page,
                         @PathVariable("id") UUID id, Model model) {
        listKT= service.getData(page);
        KichThuoc kt=service.detail(id);
        model.addAttribute("kt1",kt);
        model.addAttribute("listKT",listKT);
        return "/kichthuoc/kichthuoc";
    }

    @GetMapping("/shop-xe/kich-thuoc/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        idKTCu= id;
        KichThuoc kt=service.detail(id);
        model.addAttribute("kt1",kt);
        return "/kichthuoc/kichthuoc-update";
    }

    @GetMapping("/shop-xe/kich-thuoc/delete/{id}")
    public String remove(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/shop-xe/kich-thuoc/hien-thi";
    }

    @PostMapping("/shop-xe/kich-thuoc/add")
    public String add(@Valid @ModelAttribute("kt1") KichThuoc kt1,
                      BindingResult result, Model model) {
        service.save(kt1);
        return "redirect:/shop-xe/kich-thuoc/hien-thi";
    }

    @PostMapping("/shop-xe/kich-thuoc/update")
    public String update(@Valid @ModelAttribute("kt1") KichThuoc kt1,
                         BindingResult result, Model model) {
        kt1.setId(idKTCu);
        service.save(kt1);
        return "redirect:/shop-xe/kich-thuoc/hien-thi";
    }

}
