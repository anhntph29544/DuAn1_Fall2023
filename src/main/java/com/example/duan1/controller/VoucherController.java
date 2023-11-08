package com.example.duan1.controller;

import com.example.duan1.entity.Voucher;
import com.example.duan1.service.VoucherService;
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
public class VoucherController {
    @Autowired
    private VoucherService service;

    @GetMapping("/voucher/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list",service.getAll());
        return "/voucher/voucher";
    }

    @GetMapping("/voucher/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Voucher vc=service.detail(id);
        model.addAttribute("vc",vc);
        model.addAttribute("list",service.getAll());
        return "/voucher/voucher";
    }
    @PostMapping("/voucher/add")
    public String add( @ModelAttribute("vc") Voucher vc) {
        service.add(vc);
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("/voucher/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Voucher vc=service.detail(id);
        model.addAttribute("vc",vc);
        return "/voucher/update";
    }

    @PostMapping("/voucher/update/{id}")
    public String update(@PathVariable("id") UUID id,  @ModelAttribute("vc") Voucher vc, BindingResult result) {
        service.update(vc, id);
        return "redirect:/voucher/hien-thi";
    }
    @GetMapping("/voucher/delete/{id}")
    public String remove(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/voucher/hien-thi";
    }
}
