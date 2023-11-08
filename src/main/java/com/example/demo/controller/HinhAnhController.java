package com.example.demo.controller;

import com.example.demo.entity.HinhAnh;
import com.example.demo.service.HinhAnhService;
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
@RequestMapping("/hinh-anh")
public class HinhAnhController {
    @Autowired
    HinhAnhService hinhAnhService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<HinhAnh> list = hinhAnhService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("hinhAnh", new HinhAnh());
        return "/hinhanh/hien-thi";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("hinhAnh") HinhAnh hinhAnh){
        hinhAnhService.add(hinhAnh);
        return "redirect:/hinh-anh/hien-thi";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") HinhAnh hinhAnh){
        hinhAnhService.delete(hinhAnh);
        return "redirect:/hinh-anh/hien-thi";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        HinhAnh hinhAnh = hinhAnhService.detail(id).get();
        model.addAttribute("object",hinhAnh);
        return "/hinhanh/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute HinhAnh hinhAnh){
        hinhAnhService.update(hinhAnh,id);
        return  "redirect:/hinh-anh/hien-thi";
    }

}
