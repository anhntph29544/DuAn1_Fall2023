package com.example.duan1.controller;

import com.example.duan1.entity.HinhAnh;
import com.example.duan1.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

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
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("hinhAnh") HinhAnh hinhAnh){
        hinhAnhService.add(hinhAnh);
        return "redirect:/hinh-anh/hien-thi";
    }

}
