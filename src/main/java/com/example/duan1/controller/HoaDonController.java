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
import java.util.UUID;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonSV sv;
    private List<HoaDon> listHD = new ArrayList<>();
    @Autowired
    private HoaDonChiTietSV svHDCT;
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    @Autowired
    private KhachHangRepository repository;
    private List<KhachHang> listKH = new ArrayList<>();
    @Autowired
    private SanPhamChiTietService serviceSPCT;
    private List<SanPhamChiTiet> listSPCT = new ArrayList<>();
    private UUID idHDSelect=null;

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
        listKH = repository.findAll();
        listSPCT= serviceSPCT.getAll();
        model.addAttribute("listSPCT", listSPCT);
        if(idHDSelect==null){
            if(listHD.size()>0){
                idHDSelect = listHD.get(0).getId();
            }
        }
        listHDCT= svHDCT.getListHD(idHDSelect);
        model.addAttribute("idHDSelect",idHDSelect);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("hd", new HoaDon());
        return "/hoadon/tao-hoa-don";
    }

    @GetMapping("/chon-hoa-don/hien-thi/{idSelect}")
    public String chonHoaDon(@PathVariable(name = "idSelect")UUID idChon, Model model) {
        idHDSelect=idChon;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/tao-hoa-don/add")
    public String add() {
        HoaDon h = new HoaDon();
        h.setTinhTrang(0);
        sv.add(h);
        return "redirect:/tao-hoa-don/hien-thi";
    }

    private Boolean kiemTra(List<HoaDonChiTiet> listHDCT, UUID spctID){
        for (HoaDonChiTiet hdct: listHDCT) {
            if(hdct.getSanPhamCT().getId()==spctID){
                hdct.setSoLuong(hdct.getSoLuong()+1);
                hdct.setGia(hdct.getSoLuong()*hdct.getSanPhamCT().getGia());
                svHDCT.save(hdct);
                return false;
            }
        }
        return true;
    }

    @PostMapping("/hoa-don/them-san-pham")
    public String themSP(@RequestParam("spctID") UUID spctID) {
        HoaDonChiTiet hdct= new HoaDonChiTiet();
        HoaDon hd= sv.detail(idHDSelect);
        SanPhamChiTiet spct= serviceSPCT.detail(spctID);
        listHDCT= svHDCT.getListHD(idHDSelect);
        if (kiemTra(listHDCT, spctID)){
            hdct.setHoaDon(hd);
            hdct.setSanPhamCT(spct);
            hdct.setSoLuong(1);
            hdct.setGia(hdct.getSoLuong()*hdct.getSanPhamCT().getGia());
            hdct.setTrangThai(0);
            svHDCT.save(hdct);
        }
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @GetMapping("/hoa-don/xoa-san-pham/{id}")
    public String xoaSP(@PathVariable("id")UUID id) {
        svHDCT.delete(id);
        return "redirect:/tao-hoa-don/hien-thi";
    }

}
