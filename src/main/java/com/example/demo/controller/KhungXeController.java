package com.example.duan1.controller;

import com.example.duan1.entity.KhungXe;
import com.example.duan1.service.KhungXeService;
import jakarta.validation.Valid;
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

@Controller
public class KhungXeController {

    @Autowired
    private KhungXeService service;
    private List<KhungXe> listKX = new ArrayList<>();
    private String idCu;

    @GetMapping("/shop-xe/khung-xe")
    public String hienThi(Model model){
        listKX = service.getAll();
        model.addAttribute("kx1",new KhungXe());
        model.addAttribute("listKX",listKX);
        return "/khungxe/hien-thi";
    }

    @PostMapping("/shop-xe/khung-xe/add")
    public String add(@Valid @ModelAttribute("kx1")KhungXe kx1,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            model.addAttribute("listKX",listKX);
            return "/khungxe/hien-thi";
        }
        KhungXe kx = KhungXe.builder()
                .ma(kx1.getMa().trim())
                .ten(kx1.getTen().trim())
                .trangThai(kx1.getTrangThai())
                .build();
        service.save(kx);
        return "redirect:/shop-xe/khung-xe";
    }

    @GetMapping("/shop-xe/khung-xe/view-update/{id}")
    public String viewUpdate(@PathVariable("id")String id, Model model){
        KhungXe kx = service.detail(id);
        idCu = id;
        model.addAttribute("kx1",kx);
        return "/khungxe/update";
    }

    @PostMapping("/shop-xe/khung-xe/update")
    public String update(@Valid @ModelAttribute("kx1")KhungXe kx1,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            return "/khungxe/update";
        }
        KhungXe kx = KhungXe.builder()
                .id(idCu)
                .ma(kx1.getMa().trim())
                .ten(kx1.getTen().trim())
                .trangThai(kx1.getTrangThai())
                .build();
        service.save(kx);
        return "redirect:/shop-xe/khung-xe";
    }

}
