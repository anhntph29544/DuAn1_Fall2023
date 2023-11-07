package com.example.duan1.controller;

import com.example.duan1.entity.HinhAnh;
import com.example.duan1.entity.KichThuoc;
import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.entity.MauSac;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.service.HinhAnhService;
import com.example.duan1.service.KichThuocService;
import com.example.duan1.service.KieuDangXeService;
import com.example.duan1.service.MauSacSV;
import com.example.duan1.service.SanPhamChiTietService;
import com.example.duan1.service.SanPhamService;
import com.example.duan1.service.ThuongHieuService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietService serviceSPCT;
    private Page<SanPhamChiTiet> listSPCT;
    @Autowired
    private HinhAnhService serviceHA;
    @Autowired
    private KichThuocService serviceKT;
    @Autowired
    private KieuDangXeService serviceKDX;
    @Autowired
    private MauSacSV serviceMS;
    @Autowired
    private SanPhamService serviceSP;
    @Autowired
    private ThuongHieuService serviceTH;
    private List<HinhAnh> listHA= new ArrayList<>();
    private List<KichThuoc> listKT= new ArrayList<>();
    private List<KieuDangXe> listKDX= new ArrayList<>();
    private List<MauSac> listMS= new ArrayList<>();
    private List<SanPham> listSP= new ArrayList<>();
    private List<ThuongHieu> listTH= new ArrayList<>();
    private UUID idCu;

    @GetMapping("/shop-xe/san-pham-chi-tiet/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page, Model model){
        listSPCT= serviceSPCT.getAll(page);
        combobox(model);
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("spct1", new SanPhamChiTiet());
        return "/sanpham/hien-thi";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/add")
    public String add(@Valid @ModelAttribute("spct1")SanPhamChiTiet spct1,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            combobox(model);
            model.addAttribute("listSPCT", listSPCT);
            return "/sanpham/hien-thi";
        }
        Boolean save = serviceSPCT.save(spct1);
        return "redirect:/shop-xe/san-pham-chi-tiet/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/detail/{id}")
    public String detail(@PathVariable("id")UUID id, Model model){
        SanPhamChiTiet spct = serviceSPCT.detail(id);
        combobox(model);
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("spct1",spct);
        return "/sanpham/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        idCu =id;
        SanPhamChiTiet spct = serviceSPCT.detail(id);
        combobox(model);
        model.addAttribute("spct1",spct);
        return "/sanpham/update";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/update")
    public String update(@Valid @ModelAttribute("spct1")SanPhamChiTiet spct1,
                      BindingResult result,
                      Model model){
        spct1.setId(idCu);
        if(result.hasErrors()){
            combobox(model);
            model.addAttribute("listSPCT", listSPCT);
            return "/sanpham/hien-thi";
        }
        Boolean save = serviceSPCT.save(spct1);
        return "redirect:/shop-xe/san-pham-chi-tiet/hien-thi";
    }

    public void combobox(Model model){
        listHA= serviceHA.getAll();
        listKT= serviceKT.getAll();
        listKDX= serviceKDX.getAll();
        listMS= serviceMS.getAll();
        listSP= serviceSP.getAll();
        listTH= serviceTH.getAll();
        model.addAttribute("listHA",listHA);
        model.addAttribute("listKT",listKT);
        model.addAttribute("listKDX",listKDX);
        model.addAttribute("listMS",listMS);
        model.addAttribute("listSP",listSP);
        model.addAttribute("listTH",listTH);
    }

}
