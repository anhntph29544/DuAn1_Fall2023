package com.example.duan1.controller;

import com.example.duan1.entity.Voucher;
import com.example.duan1.service.VoucherService;
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

import java.sql.Date;
import java.util.UUID;

@Controller
public class VoucherController {
    @Autowired
    private VoucherService service;
    private UUID idCu;

    @GetMapping("/voucher/hien-thi")
    public String hienthi(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Voucher> voucher = service.getDate(page);
        model.addAttribute("list", voucher);
        return "/voucher/voucher";
    }

    @GetMapping("/voucher/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Voucher vc = service.detail(id);
        model.addAttribute("vc", vc);
        return "/voucher/voucher";
    }

    @PostMapping("/voucher/add")
    public String add(@Valid @ModelAttribute("vc") Voucher vc,
                      @RequestParam("ngayBD") Date ngayBD, @RequestParam("ngayKT") Date ngayKT) {
        java.util.Date ngayHienTaiUtil = new java.util.Date();
        Date ngayHienTai = new Date(ngayHienTaiUtil.getTime());
        if (ngayHienTai.after(ngayBD) && ngayHienTai.before(ngayKT)) {
            Voucher vc1 = Voucher.builder()
                    .ma(vc.getMa())
                    .soLuong(vc.getSoLuong())
                    .giaTri(vc.getGiaTri())
                    .ngayBD(vc.getNgayBD())
                    .ngayKT(vc.getNgayKT())
                    .trangThai(0)
                    .build();
            service.save(vc1);
        } else {
            Voucher vc1 = Voucher.builder()
                    .ma(vc.getMa())
                    .soLuong(vc.getSoLuong())
                    .giaTri(vc.getGiaTri())
                    .ngayBD(vc.getNgayBD())
                    .ngayKT(vc.getNgayKT())
                    .trangThai(1)
                    .build();
            service.save(vc1);
        }
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("/voucher/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Voucher vc = service.detail(id);
        idCu = id;
        model.addAttribute("vc", vc);
        return "/voucher/update";
    }

    @PostMapping("/voucher/update")
    public String update(@Valid @ModelAttribute("vc") Voucher vc,
                         @RequestParam("ngayBD") Date ngayBD, @RequestParam("ngayKT") Date ngayKT) {
        java.util.Date ngayHienTaiUtil = new java.util.Date();
        Date ngayHienTai = new Date(ngayHienTaiUtil.getTime());
        if (ngayHienTai.after(ngayBD) && ngayHienTai.before(ngayKT)) {
            Voucher vc1 = Voucher.builder()
                    .id(idCu)
                    .ma(vc.getMa())
                    .soLuong(vc.getSoLuong())
                    .giaTri(vc.getGiaTri())
                    .ngayBD(vc.getNgayBD())
                    .ngayKT(vc.getNgayKT())
                    .trangThai(0)
                    .build();
            service.save(vc1);
        } else {
            Voucher vc1 = Voucher.builder()
                    .id(idCu)
                    .ma(vc.getMa())
                    .soLuong(vc.getSoLuong())
                    .giaTri(vc.getGiaTri())
                    .ngayBD(vc.getNgayBD())
                    .ngayKT(vc.getNgayKT())
                    .trangThai(1)
                    .build();
            service.save(vc1);
        }
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("/voucher/delete/{id}")
    public String remove(@PathVariable("id") UUID id) {
        Voucher vc = service.detail(id);
        vc.setTrangThai(1);
        service.save(vc);
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("/voucher/search")
    public String search(@RequestParam("ngayBD") Date ngayBD, @RequestParam("ngayKT") Date ngayKT, Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Voucher> voucher = service.search(ngayBD, ngayKT, page);
        model.addAttribute("list", voucher);
        return "/voucher/voucher";
    }
}
