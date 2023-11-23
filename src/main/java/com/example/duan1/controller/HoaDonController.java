package com.example.duan1.controller;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.repository.KhachHangRepository;
import com.example.duan1.service.HoaDonSV;
import com.example.duan1.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonSV sv;
    private List<HoaDon> listHD = new ArrayList<>();
    @Autowired
    private KhachHangRepository repository;
    private List<KhachHang> listKH = new ArrayList<>();

    @GetMapping("/hoa-don/hien-thi")
    public String hienThi(Model model) {
        listHD = sv.getCHT();
        listKH = repository.findAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("hd", new HoaDon());
        return "/hoadon/hienThi";
    }

//    @PostMapping("/hoa-don/add")
//    public String add(@Valid @ModelAttribute("hd") HoaDon h) {
//        sv.add(h);
//        return "redirect:/hoa-don/hien-thi";
//    }


}
