package com.example.duan1.controller;

import com.example.duan1.entity.NSX;
import com.example.duan1.service.NSXSV;
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
public class NSXController {
    @Autowired
    private NSXSV sv;
    private List<NSX> listN=new ArrayList<>();
    @GetMapping("/nsx/hien-thi")
    public String hineThi(Model model){
        listN=sv.getAll();
        model.addAttribute("n1", new NSX());
        model.addAttribute("listN",listN);
        return "nsx";
    }
    @GetMapping("/nsx/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        NSX n = sv.detail(id);
        listN = sv.getAll();
        model.addAttribute("listN", listN);
        model.addAttribute("n1", n);
        return "nsx";
    }
    @PostMapping("/nsx/add")
    public String add( @ModelAttribute("n1") NSX n) {
        sv.add(n);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("/nsx/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        NSX d = sv.detail(id);
        model.addAttribute("n1", d);
        return "nsx-update";
    }

    @PostMapping("/nsx/update/{id}")
    public String update(@PathVariable("id") UUID id,  @ModelAttribute("n1") NSX p, BindingResult result) {
        sv.update(p, id);
        return "redirect:/nsx/hien-thi";
    }
}
