package com.example.demo.controller;

import com.example.demo.entity.BanDap;
import com.example.demo.service.BanDapService;
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
public class BanDapController {

    @Autowired
    private BanDapService service;
    private List<BanDap> listBD= new ArrayList<>();
    private UUID idLX;

    @GetMapping("/ban-dap/hien-thi")
    public String hienThi(Model model){
        listBD= service.getAll();
        model.addAttribute("listBD", listBD);
        model.addAttribute("bd1", new BanDap());
        return "/bandap/hien-thi";
    }

    @GetMapping("/ban-dap/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        listBD= service.getAll();
        BanDap bd= service.detail(id);
        model.addAttribute("listBD", listBD);
        model.addAttribute("bd1", bd);
        return "/bandap/hien-thi";
    }

    @GetMapping("/ban-dap/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        idLX= id;
        BanDap bd= service.detail(id);
        model.addAttribute("bd1", bd);
        return "/bandap/update";
    }

    @GetMapping("/ban-dap/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model){
        service.delete(id);
        return "redirect:/ban-dap/hien-thi";
    }

    @PostMapping("/ban-dap/add")
    public String add(@Valid @ModelAttribute("bd1") BanDap bd1,
                      BindingResult result, Model model){
        bd1= BanDap.builder()
                .ma(bd1.getMa().trim())
                .ten(bd1.getTen().trim())
                .trangThai(bd1.getTrangThai())
                .build();
        if(result.hasErrors()){
            listBD= service.getAll();
            model.addAttribute("listBD", listBD);
            return "/bandap/hien-thi";
        }
        service.save(bd1);
        return "redirect:/ban-dap/hien-thi";
    }

    @PostMapping("/ban-dap/update")
    public String update(@Valid @ModelAttribute("bd1") BanDap bd1,
                         BindingResult result, Model model){
        bd1= BanDap.builder()
                .id(idLX)
                .ma(bd1.getMa().trim())
                .ten(bd1.getTen().trim())
                .trangThai(bd1.getTrangThai())
                .build();
        if(result.hasErrors()){
            return "/bandap/update";
        }
        service.save(bd1);
        return "redirect:/ban-dap/hien-thi";
    }

}
