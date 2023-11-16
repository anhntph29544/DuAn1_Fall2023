package com.example.duan1.controller;

import com.example.duan1.entity.SanPham;
import com.example.duan1.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService service;
    private Page<SanPham> listSP;
    private SanPham sp;

    @GetMapping("/shop-xe/san-pham")
    public String viewSP(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "tenSearch",defaultValue = "") String ten,
                         @RequestParam(value = "trangThaiSearch",defaultValue = "3")Integer trangThai,
                         Model model){
        listSP= service.getData(page);
        if(!ten.trim().isEmpty()){
            listSP= service.searchPage(ten.trim(),trangThai, page);
            model.addAttribute("tenSearch", ten.trim());
        }else if(trangThai!=3){
            listSP= service.searchPage(ten.trim(),trangThai, page);
        }
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", new SanPham());
        return "sanpham/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "tenSearch",defaultValue = "") String ten, Model model){
        listSP= service.getData(page);
        if(!ten.trim().isEmpty()){
            listSP= service.searchPage(ten.trim(),3, page);
            model.addAttribute("tenSearch", ten.trim());
        }
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", new SanPham());
        return "sanpham/sanphams";
    }

    @GetMapping("/shop-xe/san-pham/detail/{id}")
    public String detail(@RequestParam(value = "page", defaultValue = "0") int page,
                         @PathVariable("id")UUID id, Model model){
        listSP= service.getData(page);
        sp= service.detail(id);
        model.addAttribute("listSP", listSP);
        model.addAttribute("sp1", sp);
        return "sanpham/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        service.delete(id);
        return "redirect:/shop-xe/san-pham/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        sp= service.detail(id);
        model.addAttribute("sp1", sp);
        return "sanpham/update";
    }

    @PostMapping("/shop-xe/san-pham/add")
    public String add(@Valid @ModelAttribute("sp1")SanPham sp1,
                      BindingResult result,
                      @RequestParam(value = "page", defaultValue = "0") int page,
                      Model model){
        listSP= service.getData(page);
        if(result.hasErrors()){
            model.addAttribute("listSP", listSP);
            return "sanpham/hien-thi";
        }
        if(!kiemTra(sp1,model)){
            model.addAttribute("listSP", listSP);
            return "sanpham/hien-thi";
        }
        sp1.setTen(sp1.getTen().replaceAll("\\s\\s+", " ").trim());
        service.save(sp1);
        return "redirect:/shop-xe/san-pham";
    }

    private boolean kiemTra(SanPham sp1, Model model){
        if (sp1.getTen().replaceAll("\\s\\s+", " ").trim().length()>50){
            model.addAttribute("tenError", "Tên không được quá 50 kí tự");
            return false;
        }
        for (SanPham sp: listSP) {
            if(sp1.getTen().replaceAll("\\s\\s+", " ").trim().equalsIgnoreCase(sp.getTen())){
                model.addAttribute("tenError", "Tên đã tồn tại");
                return false;
            }
        }
        return true;
    }

    @PostMapping("/shop-xe/san-pham/update")
    public String update(@Valid @ModelAttribute("sp1")SanPham sp1,
                      BindingResult result, Model model){
        if(result.hasErrors()){
            return "sanpham/update";
        }
        if(sp1.getTen().replaceAll("\\s\\s+", " ").trim().equalsIgnoreCase(sp.getTen())){
            sp.setTen(sp1.getTen().replaceAll("\\s\\s+", " ").trim());
            sp.setTrangThai(sp1.getTrangThai());
            service.save(sp);
            return "redirect:/shop-xe/san-pham";
        }
        if(!kiemTra(sp1,model)){
            return "sanpham/update";
        }
        sp.setTen(sp1.getTen().replaceAll("\\s\\s+", " ").trim());
        sp.setTrangThai(sp1.getTrangThai());
        service.save(sp);
        return "redirect:/shop-xe/san-pham";
    }

}
