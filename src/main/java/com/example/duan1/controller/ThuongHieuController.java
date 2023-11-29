package com.example.duan1.controller;

import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;
    private int page;
    private Page<ThuongHieu> list;
    private ThuongHieu th;

    @GetMapping("/shop-xe/thuong-hieu/hien-thi")
    public String hienThi(@RequestParam(name = "page",defaultValue = "0")int page1,
                          @RequestParam(name = "tenSearch",defaultValue = "") String ten,
                          Model model){
        page = page1;
        list = thuongHieuService.getData(page);
        if(ten.trim()!=""){
            list = thuongHieuService.searchPage(ten.trim(),page1);
            model.addAttribute("tenSearch",ten.trim());
        }
        model.addAttribute("list", list);
        model.addAttribute("th1", new ThuongHieu());
        return "/thuonghieu/thuonghieus";
    }

    @PostMapping("/shop-xe/thuong-hieu/add")
    public String add(@Valid @ModelAttribute("th1") ThuongHieu thuongHieu){
        thuongHieuService.save(thuongHieu);
        return "redirect:/shop-xe/thuong-hieu/hien-thi";
    }

    @GetMapping("/shop-xe/thuong-hieu/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        th = thuongHieuService.detail(id);
        model.addAttribute("th1",th);
        return "/thuonghieu/update";
    }

    @GetMapping("/shop-xe/thuong-hieu/detail/{id}")
    public String detail(@PathVariable("id")UUID id, Model model){
        ThuongHieu th = thuongHieuService.detail(id);
        list = thuongHieuService.getData(page);
        model.addAttribute("th1",th);
        model.addAttribute("list", list);
        return "/thuonghieu/thuonghieus";
    }

    @GetMapping("/shop-xe/thuong-hieu/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        ThuongHieu th = thuongHieuService.detail(id);
        thuongHieuService.delete(th);
        return "redirect:/shop-xe/thuong-hieu/hien-thi";
    }

    @PostMapping("/shop-xe/thuong-hieu/update")
    public String update(@Valid @ModelAttribute("th1")ThuongHieu th1){
        th.setTen(th1.getTen().trim());
        th.setTrangThai(th.getTrangThai());
        thuongHieuService.save(th);
        return "redirect:/shop-xe/thuong-hieu/hien-thi";
    }

}
