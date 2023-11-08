package com.example.demo.controller;

import com.example.demo.entity.LopXe;
import com.example.demo.service.LopXeService;
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
import java.util.UUID;

@Controller
public class LopXeController {

    @Autowired
    private LopXeService service;
    private List<LopXe> listLX= new ArrayList<>();
    private UUID idLX;

    @GetMapping("/lop-xe/hien-thi")
    public String hienThi(Model model){
        listLX= service.getAll();
        model.addAttribute("listLX", listLX);
        model.addAttribute("lx1", new LopXe());
        return "/lopxe/hien-thi";
    }

    @GetMapping("/lop-xe/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        listLX= service.getAll();
        LopXe lx= service.detail(id);
        model.addAttribute("listLX", listLX);
        model.addAttribute("lx1", lx);
        return "/lopxe/hien-thi";
    }

    @GetMapping("/lop-xe/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        idLX= id;
        LopXe lx= service.detail(id);
        model.addAttribute("lx1", lx);
        return "/lopxe/update";
    }

    @GetMapping("/lop-xe/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model){
        service.delete(id);
        return "redirect:/lop-xe/hien-thi";
    }

    @PostMapping("/lop-xe/add")
    public String add(@Valid @ModelAttribute("lx1") LopXe lx1,
                      BindingResult result, Model model){
        lx1= LopXe.builder()
                .ma(lx1.getMa().trim())
                .ten(lx1.getTen().trim())
                .trangThai(lx1.getTrangThai())
                .build();
        if(result.hasErrors()){
            listLX= service.getAll();
            model.addAttribute("listLX", listLX);
            return "/lopxe/hien-thi";
        }
        service.save(lx1);
        return "redirect:/lop-xe/hien-thi";
    }

    @PostMapping("/lop-xe/update")
    public String update(@Valid @ModelAttribute("lx1") LopXe lx1,
                      BindingResult result, Model model){
        lx1= LopXe.builder()
                .id(idLX)
                .ma(lx1.getMa().trim())
                .ten(lx1.getTen().trim())
                .trangThai(lx1.getTrangThai())
                .build();
        if(result.hasErrors()){
            return "/lopxe/update";
        }
        service.save(lx1);
        return "redirect:/lop-xe/hien-thi";
    }

}
