package com.example.duan1.controller;

import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.service.KieuDangXeService;
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
public class KieuDangXeController {

    @Autowired
    private KieuDangXeService service;
    private Page<KieuDangXe> listkdx;
    private KieuDangXe kdx;
    private int page;

    @GetMapping("/shop-xe/kieu-dang-xe/hien-thi")
    public String hienThi(@RequestParam(name = "page",defaultValue = "0")int page1,
                          @RequestParam(name = "tenSearch",defaultValue = "") String ten,
                          Model model){
        page = page1;
        listkdx = service.getData(page);
        if(ten.trim()!=""){
            listkdx = service.searchPage(ten.trim(),page);
            model.addAttribute("tenSearch",ten.trim());
        }
        model.addAttribute("kdx1",new KieuDangXe());
        model.addAttribute("listkdx",listkdx);
        return "/kieudangxe/hien-thi";
    }

    @PostMapping("/shop-xe/kieu-dang-xe/add")
    public String add(@Valid @ModelAttribute("kdx1")KieuDangXe kdx1,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            model.addAttribute("listkdx",listkdx);
            return "/kieudangxe/hien-thi";
        }
        KieuDangXe kdx = KieuDangXe.builder()
                .ten(kdx1.getTen().trim())
                .trangThai(kdx1.getTrangThai())
                .build();
        service.save(kdx);
        return "redirect:/shop-xe/kieu-dang-xe/hien-thi";
    }

    @GetMapping("/shop-xe/kieu-dang-xe/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        kdx = service.detail(id);
        model.addAttribute("kdx1",kdx);
        return "/kieudangxe/update";
    }

    @GetMapping("/shop-xe/kieu-dang-xe/detail/{id}")
    public String detail(@PathVariable("id")UUID id, Model model){
        listkdx = service.getData(page);
        KieuDangXe kdx = service.detail(id);
        model.addAttribute("kdx1",kdx);
        model.addAttribute("listkdx",listkdx);
        return "/kieudangxe/hien-thi";
    }

    @GetMapping("/shop-xe/kieu-dang-xe/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        service.remove(id);
        return "redirect:/shop-xe/kieu-dang-xe/hien-thi";
    }

    @PostMapping("/shop-xe/kieu-dang-xe/update")
    public String update(@Valid @ModelAttribute("kdx1")KieuDangXe kdx1,
                         BindingResult result){
        if(result.hasErrors()){
            return "/kieudangxe/update";
        }
        kdx.setTen(kdx1.getTen());
        kdx.setTrangThai(kdx1.getTrangThai());
        service.save(kdx);
        return "redirect:/shop-xe/kieu-dang-xe/hien-thi";
    }

}
