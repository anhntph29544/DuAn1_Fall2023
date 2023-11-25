package com.example.duan1.controller;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.HoaDonChiTiet;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class HoaDonController {
    @Autowired
    private HoaDonSV sv;
    private List<HoaDon> listHD = new ArrayList<>();
    @Autowired
    KhachHangService khsv;
    @Autowired
    private KhachHangRepository repository;
    private List<KhachHang> listKH = new ArrayList<>();
    private UUID idHDSelect = null;

    @GetMapping("/hoa-don/hien-thi")
    public String hienThi(Model model) {
        listHD = sv.getCHT();
        listKH = repository.findAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("hd", new HoaDon());
        return "/hoadon/hienThi";
    }

    @GetMapping("/tao-hoa-don/hien-thi")
    public String taoHoaDon(Model model) {
        listHD = sv.getCHT();
        listKH=repository.findAll();
        KhachHang kh = sv.layKHchoHD(idHDSelect);
        if (idHDSelect == null) {
            idHDSelect = listHD.get(0).getId();
        }
        model.addAttribute("kh",kh);
        model.addAttribute("idHDSelect", idHDSelect);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("hd", new HoaDon());
        return "/hoadon/tao-hoa-don";
    }

    @GetMapping("/chon-hoa-don/hien-thi/{idSelect}")
    public String chonHoaDon(@PathVariable(name = "idSelect") UUID idChon, Model model) {
        idHDSelect = idChon;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/tao-hoa-don/add")
    public String add() {
        HoaDon h = new HoaDon();
        h.setTinhTrang(0);
        sv.add(h);
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/hoa-don/them-khach-hang")
    public String addKH(@RequestParam("KHID") UUID khid) {
        HoaDon hd = sv.detail(idHDSelect);
        Optional<KhachHang> svc = khsv.detail(khid);
        hd.setKhachHang(svc.get());
        sv.add(hd);
        return "redirect:/tao-hoa-don/hien-thi";
    }


}
