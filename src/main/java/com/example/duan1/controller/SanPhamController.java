package com.example.duan1.controller;

import com.example.duan1.entity.SanPham;
import com.example.duan1.service.SanPhamService;
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
public class SanPhamController {

    @Autowired
    private SanPhamService service;
    private Page<SanPham> listSP;
    private UUID idSPCu;

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "tenSearch",defaultValue = "") String ten, Model model){
        listSP= service.getData(page);
        if(ten.trim() != ""){
            listSP= service.searchPage(ten.trim(), page);
            model.addAttribute("tenSearch", ten.trim());
        }
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", new SanPham());
        return "sanpham/sanphams";
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detail(@RequestParam(value = "page", defaultValue = "0") int page,
                         @PathVariable("id")UUID id, Model model){
        listSP= service.getData(page);
        SanPham sp= service.detail(id);
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", sp);
        return "sanpham/sanphams";
    }

    @GetMapping("/san-pham/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/shop-xe/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        idSPCu=id;
        SanPham sp= service.detail(id);
        model.addAttribute("sp1", sp);
        return "sanpham/update";
    }

    @PostMapping("/san-pham/add")
    public String add(@Valid @ModelAttribute("sp1")SanPham sp1,
                      BindingResult result, Model model){
        service.save(sp1);
        return "redirect:/shop-xe/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/update")
    public String update(@Valid @ModelAttribute("sp1")SanPham sp1,
                      BindingResult result, Model model){
        sp1.setId(idSPCu);
        service.save(sp1);
        return "redirect:/shop-xe/san-pham/hien-thi";
    }


}
