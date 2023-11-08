package com.example.demo.controller;

import com.example.demo.entity.GhiDong;
import com.example.demo.service.GhiDongService;
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
public class GhiDongController {

    @Autowired
    private GhiDongService service;
    private List<GhiDong> listGD= new ArrayList<>();
    private UUID idGD;

    @GetMapping("/ghi-dong/hien-thi")
    public String hienThi(Model model){
        listGD= service.getAll();
        model.addAttribute("listGD", listGD);
        model.addAttribute("gd1", new GhiDong());
        return "/ghidong/hien-thi";
    }

    @GetMapping("/ghi-dong/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        listGD= service.getAll();
        GhiDong gd= service.detail(id);
        model.addAttribute("listGD", listGD);
        model.addAttribute("gd1", gd);
        return "/ghidong/hien-thi";
    }

    @GetMapping("/ghi-dong/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        idGD= id;
        GhiDong gd= service.detail(id);
        model.addAttribute("gd1", gd);
        return "/ghidong/update";
    }

    @GetMapping("/ghi-dong/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model){
        service.delete(id);
        return "redirect:/ghi-dong/hien-thi";
    }

    @PostMapping("/ghi-dong/add")
    public String add(@Valid @ModelAttribute("gd1") GhiDong gd1,
                      BindingResult result, Model model){
        gd1= GhiDong.builder()
                .ma(gd1.getMa().trim())
                .ten(gd1.getTen().trim())
                .trangThai(gd1.getTrangThai())
                .build();
        if(result.hasErrors()){
            listGD= service.getAll();
            model.addAttribute("listGD", listGD);
            return "/ghidong/hien-thi";
        }
        service.save(gd1);
        return "redirect:/ghi-dong/hien-thi";
    }

    @PostMapping("/ghi-dong/update")
    public String update(@Valid @ModelAttribute("gd1") GhiDong gd1,
                         BindingResult result, Model model){
        gd1= GhiDong.builder()
                .id(idGD)
                .ma(gd1.getMa().trim())
                .ten(gd1.getTen().trim())
                .trangThai(gd1.getTrangThai())
                .build();
        if(result.hasErrors()){
            return "/ghidong/update";
        }
        service.save(gd1);
        return "redirect:/ghi-dong/hien-thi";
    }

}
