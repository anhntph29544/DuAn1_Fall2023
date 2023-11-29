package com.example.duan1.controller;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.HoaDonChiTiet;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.repository.KhachHangRepository;
import com.example.duan1.service.HoaDonChiTietSV;
import com.example.duan1.service.HoaDonSV;
import com.example.duan1.service.KhachHangService;
import com.example.duan1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private List<HoaDon> listPage = new ArrayList<>();
    private List<HoaDon> listCTT = new ArrayList<>();
    private List<HoaDon> listDTT = new ArrayList<>();
    private List<HoaDon> listHuy = new ArrayList<>();
    private List<HoaDon> listHDc = new ArrayList<>();
    private HoaDon h;
    private HoaDonChiTiet hdct;
    @Autowired
    private HoaDonChiTietSV svHDCT;
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT1 = new ArrayList<>();

    @Autowired
    private KhachHangService khsv;
    @Autowired
    private KhachHangRepository repository;
    private List<KhachHang> listKH = new ArrayList<>();
    @Autowired
    private SanPhamChiTietService serviceSPCT;
    private List<SanPhamChiTiet> listSPCT = new ArrayList<>();
    private UUID idHDSelect = null;
    private Integer errorSL = 0;

    @GetMapping("/hoa-don/hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        listPage = sv.getAll();
        listKH = repository.findAll();
        listSPCT = serviceSPCT.getAll();
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listPage);
        return "/hoadon/hienThi";
    }

    @GetMapping("hoa-don/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        listHD = sv.getAll();
        listHDCT = svHDCT.getListHD(id);
        listHDCT1 = svHDCT.getListHD(id);
        h = sv.detail(id);
        model.addAttribute("h1", h);
        model.addAttribute("listHDCT1", listHDCT1);
        model.addAttribute("listHDCT", listHDCT);
        return "hoadon/chitiet";
    }

    @GetMapping("/hoa-don/hien-thi/dh")
    public String hienThiCTT(Model model) {
        listHuy = sv.getHUy();
        listKH = repository.findAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHuy);
        return "/hoadon/hienThi";
    }

    @GetMapping("/hoa-don/hien-thi/dtt")
    public String hienThiDTT(Model model) {
        listDTT = sv.getDTT();
        listKH = repository.findAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listDTT);
        return "/hoadon/hienThi";
    }

    @GetMapping("/tao-hoa-don/hien-thi")
    public String taoHoaDon(Model model) {
        listHD = sv.getCHT();
        listKH = repository.findAll();
        listSPCT = serviceSPCT.getAll();
        model.addAttribute("listSPCT", listSPCT);
        if (idHDSelect == null) {
            if (listHD.size() > 0) {
                idHDSelect = listHD.get(0).getId();
            }
        }
        Double sum = 0.0;
        List<HoaDonChiTiet> listTT = svHDCT.getListHD(idHDSelect);
        for (HoaDonChiTiet hdct : listTT) {
            sum += hdct.getSanPhamCT().getGia() * hdct.getSoLuong();
        }
        KhachHang kh = sv.layKHchoHD(idHDSelect);
        listHDCT = svHDCT.getListHD(idHDSelect);
        model.addAttribute("tamTinh", sum);
        model.addAttribute("idHDSelect", idHDSelect);
        model.addAttribute("kh", kh);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("hd", new HoaDon());
        model.addAttribute("errorSL", errorSL);
        errorSL = 0;
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
        h.setKhachHang(sv.KHL());
        h.setTinhTrang(0);
        sv.add(h);
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/hoa-don/thanh-toan")
    public String update(@RequestParam("tamTinh") Double tamTinh) {
        HoaDon hd = sv.detail(idHDSelect);
        hd.setTinhTrang(1);
        hd.setNgayThanhToan(new java.util.Date());
        hd.setThanhTien(tamTinh);
        if (hd.getKhachHang() == null) {
            hd.setKhachHang(sv.KHL());
        }
        sv.add(hd);
        idHDSelect = null;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/hoa-don/huy")
    public String huy(@RequestParam("tamTinh") Double tamTinh) {
        HoaDon hd1 = sv.detail(idHDSelect);
        hd1.setTinhTrang(2);
        hd1.setThanhTien(tamTinh);
        if (hd1.getKhachHang() == null) {
            hd1.setKhachHang(sv.KHL());
        }
        sv.add(hd1);
        idHDSelect = null;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    private Boolean kiemTra(List<HoaDonChiTiet> listHDCT, UUID spctID) {
        SanPhamChiTiet spct = serviceSPCT.detail(spctID);
        for (HoaDonChiTiet hdct : listHDCT) {
            if (hdct.getSanPhamCT().getId() == spctID) {
                hdct.setSoLuong(hdct.getSoLuong() + 1);
                hdct.setGia(hdct.getSoLuong() * hdct.getSanPhamCT().getGia());
                svHDCT.save(hdct);
                spct.setSoLuong(spct.getSoLuong() - 1);
                serviceSPCT.save(spct);
                return false;
            }
        }
        return true;
    }

    @PostMapping("/hoa-don/them-san-pham")
    public String themSP(@RequestParam("spctID") UUID spctID) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        HoaDon hd = sv.detail(idHDSelect);
        SanPhamChiTiet spct = serviceSPCT.detail(spctID);
        listHDCT = svHDCT.getListHD(idHDSelect);
        if (kiemTra(listHDCT, spctID)) {
            hdct.setHoaDon(hd);
            hdct.setSanPhamCT(spct);
            hdct.setSoLuong(1);
            hdct.setGia(hdct.getSoLuong() * hdct.getSanPhamCT().getGia());
            hdct.setTrangThai(0);
            svHDCT.save(hdct);
            spct.setSoLuong(spct.getSoLuong() - hdct.getSoLuong());
            serviceSPCT.save(spct);
            return "redirect:/tao-hoa-don/hien-thi";
        }
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/hoa-don/sua-san-pham")
    public String suaSP(@ModelAttribute("hdct") HoaDonChiTiet hdctMoi) {
        HoaDonChiTiet hdctCu = svHDCT.detail(hdctMoi.getId());
        SanPhamChiTiet spct = serviceSPCT.detail(hdctCu.getSanPhamCT().getId());
        if (hdctMoi.getSoLuong() < 0) {
            errorSL = 2;
            return "redirect:/tao-hoa-don/hien-thi";
        }
        if (hdctMoi.getSoLuong() == 0) {
            return "redirect:/hoa-don/xoa-san-pham/" + hdctMoi.getId();
        }
        if ((spct.getSoLuong() + hdctCu.getSoLuong()) - hdctMoi.getSoLuong() >= 0) {
            if (hdctCu.getSoLuong() < hdctMoi.getSoLuong() || hdctCu.getSoLuong() > hdctMoi.getSoLuong()) {
                spct.setSoLuong((spct.getSoLuong() + hdctCu.getSoLuong()) - hdctMoi.getSoLuong());
                hdctCu.setSoLuong(hdctMoi.getSoLuong());
                svHDCT.save(hdctCu);
                serviceSPCT.save(spct);
                return "redirect:/tao-hoa-don/hien-thi";
            }
        }
        errorSL = 1;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @GetMapping("/hoa-don/xoa-san-pham/{id}")
    public String xoaSP(@PathVariable("id") UUID id) {
        HoaDonChiTiet hdct = svHDCT.detail(id);
        SanPhamChiTiet spct = serviceSPCT.detail(hdct.getSanPhamCT().getId());
        spct.setSoLuong(spct.getSoLuong() + hdct.getSoLuong());
        serviceSPCT.save(spct);
        svHDCT.delete(id);
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
