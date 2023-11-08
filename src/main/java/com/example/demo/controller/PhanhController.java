package com.example.demo.controller;

import com.example.demo.entity.Phanh;
import com.example.demo.service.PhanhService;
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
public class PhanhController {
    @Autowired
    private PhanhService service;

    @GetMapping("/phanh/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("list",service.getAll());
        return "/phanh/phanh";
    }

    @GetMapping("/phanh/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Phanh p=service.detail(id);
        model.addAttribute("p",p);
        model.addAttribute("list",service.getAll());
        return "/phanh/phanh";
    }
    @PostMapping("/phanh/add")
    public String add( @ModelAttribute("p") Phanh p) {
        service.add(p);
        return "redirect:/phanh/hien-thi";
    }

    @GetMapping("/phanh/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Phanh p=service.detail(id);
        model.addAttribute("p",p);
        return "/phanh/phanh-update";
    }

    @PostMapping("/phanh/update/{id}")
    public String update(@PathVariable("id") UUID id,  @ModelAttribute("p") Phanh p, BindingResult result) {
        service.update(p, id);
        return "redirect:/phanh/hien-thi";
    }
    @GetMapping("/phanh/delete/{id}")
    public String remove(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/phanh/hien-thi";
    }
}
