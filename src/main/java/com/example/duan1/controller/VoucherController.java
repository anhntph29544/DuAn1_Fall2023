package com.example.duan1.controller;

import com.example.duan1.entity.Voucher;
import com.example.duan1.service.VoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
        if (!model.containsAttribute("vc")
        ) {
            model.addAttribute("vc", new Voucher());
        }
        return "/voucher/voucher";
    }

    @GetMapping("/voucher/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Voucher vc = service.detail(id);
        model.addAttribute("vc", vc);
        return "/voucher/voucher";
    }

    @PostMapping("/voucher/add")
    public String add(@Valid @ModelAttribute("vc") Voucher vc, BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes, @RequestParam(name = "page", defaultValue = "0") int page
    ) {
        try {
            java.util.Date ngayHienTaiUtil = new java.util.Date();
            Date ngayHienTai = new Date(ngayHienTaiUtil.getTime());
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vc", bindingResult);
                redirectAttributes.addFlashAttribute("vc", vc);
                System.out.println(bindingResult);
            } else {
//                if (vc.getNgayBD() == null && vc.getNgayKT() == null) {
//                    // Xử lý khi ngày bắt đầu hoặc ngày kết thúc là null
//                    model.addAttribute("erros", "Ngày bắt đầu hoặc ngày kết thúc không được để trống");
//                    model.addAttribute("list", service.getDate(page));
//                    return "/voucher/voucher";
//                }
                if (vc.getNgayKT().compareTo(vc.getNgayBD()) <= 0) {
                    System.out.println(vc.getNgayKT().compareTo(vc.getNgayBD()) <= 0);
                    model.addAttribute("erros", "Ngày Kết Thúc Phải Lớn Hơn Ngày Bắt Đầu");
                    model.addAttribute("list", service.getDate(page));
                    return "/voucher/voucher";
                }else
                    if (ngayHienTai.after(vc.getNgayBD()) && ngayHienTai.before(vc.getNgayKT())) {
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
            }
            return "redirect:/voucher/hien-thi";

    } catch(
    Exception e)

    {
        e.printStackTrace();
        return null;
    }

}

    @GetMapping("/voucher/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        Voucher vc = service.detail(id);
        idCu = id;
        model.addAttribute("vc", vc);
        return "/voucher/update";
    }

    @PostMapping("/voucher/update")
    public String update(@Valid @ModelAttribute("vc") Voucher vc) {
        java.util.Date ngayHienTaiUtil = new java.util.Date();
        Date ngayHienTai = new Date(ngayHienTaiUtil.getTime());
        if (ngayHienTai.after(vc.getNgayBD()) && ngayHienTai.before(vc.getNgayKT())) {
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
        service.delete(id);
        return "redirect:/voucher/hien-thi";
    }

    @GetMapping("/voucher/search")
    public String search(@RequestParam("ngayBD") Date ngayBD, @RequestParam("ngayKT") Date ngayKT, Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Voucher> voucher = service.search(ngayBD, ngayKT, page);
        model.addAttribute("list", voucher);
        model.addAttribute("vc",new Voucher());
        if (ngayKT.compareTo(ngayBD) <= 0) {
            model.addAttribute("erros1", "Ngày Kết Thúc Phải Lớn Hơn Ngày Bắt Đầu");
            model.addAttribute("list", service.getDate(page));
            return "/voucher/voucher";
        }
        return "/voucher/voucher";
    }

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class kiemTraTrangThai {

}

    @Scheduled(initialDelay = 1000, fixedDelay = 60 * 12 * 1000)
    void kiemTra() {
        java.util.Date ngayHienTaiUtil = new java.util.Date();
        Date ngayHienTai = new Date(ngayHienTaiUtil.getTime());
        List<Voucher> allVouchers = service.getAll();

        for (Voucher vc : allVouchers) {
            boolean found = false;
            for (int i = 0; i < allVouchers.size(); i++) {
                if (ngayHienTai.after(vc.getNgayBD()) && ngayHienTai.before(vc.getNgayKT())) {
                    vc.setTrangThai(0);
                    found = true;
                    service.save(vc);
                    break;
                }
            }

            if (!found) {
                vc.setTrangThai(1);
                service.save(vc);
            }
        }
    }
}
