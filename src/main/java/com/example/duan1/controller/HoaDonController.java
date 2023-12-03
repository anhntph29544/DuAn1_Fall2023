package com.example.duan1.controller;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.HoaDonChiTiet;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.entity.Voucher;
import com.example.duan1.repository.KhachHangRepository;
import com.example.duan1.repository.VoucherRepository;
import com.example.duan1.service.HoaDonChiTietSV;
import com.example.duan1.service.HoaDonSV;
import com.example.duan1.service.KhachHangService;
import com.example.duan1.service.SanPhamChiTietService;
import com.example.duan1.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class HoaDonController {
    @Autowired
    private HoaDonSV sv;
    private List<HoaDon> listHD = new ArrayList<>();
    private List<HoaDon> listHDc = new ArrayList<>();
    private HoaDon h;
    private HoaDonChiTiet hdct;
    private Page<HoaDon> listHD1;

    @Autowired
    private HoaDonChiTietSV svHDCT;
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT1 = new ArrayList<>();
    @Autowired
    private VoucherRepository voucherRepository;
    private VoucherService voucherService;
    private List<Voucher> listV = new ArrayList<>();
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
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "ngayBD", defaultValue = "") String ngayBDS,
                          @RequestParam(value = "ngayKT", defaultValue = "") String ngayKTS,
                          @RequestParam(value = "trangThai", defaultValue = "3") Integer trangThai) {
        listHD1 = sv.getData(page);
        Date ngayBD = null;
        Date ngayKT = null;
//        if(ngayBDS != null && ngayKTS != null || ngayBDS != "" && ngayKTS != ""){
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                ngayBD = sdf.parse(ngayBDS);
//                ngayKT = sdf.parse(ngayKTS);
//                System.out.println("hehe");
//                listHD1 = sv.search1(ngayBD, ngayKT, trangThai, page);
//                model.addAttribute("ngayBD", ngayBD);
//                model.addAttribute("ngayKT", ngayKT);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else
        if (trangThai != 3) {
            listHD1 = sv.search1(ngayBD, ngayKT, trangThai, page);
        }
        listKH = repository.findAll();
        listSPCT = serviceSPCT.getAll();
        listV = voucherRepository.findAll();
        model.addAttribute("listV", listV);
        model.addAttribute("trangThai", trangThai);
        for (HoaDon test : listHD1) {
            System.out.println(test.getMa());
        }
        model.addAttribute("listHD", listHD1);
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("listKH", listKH);
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

    @GetMapping("/tao-hoa-don/hien-thi")
    public String taoHoaDon(Model model) {
        model.addAttribute("nv",TrangChuController.nvDN);
        Double sum = 0.0;
        Double tongTien = 0.0;
        listHD = sv.getCHT();
        listV = voucherRepository.findAll();
        listKH = repository.findAll();
        listSPCT = serviceSPCT.getAll();
        model.addAttribute("listSPCT", listSPCT);
        List<HoaDonChiTiet> listTT = svHDCT.getListHD(idHDSelect);
        for (HoaDonChiTiet hdct : listTT) {
            sum += hdct.getSanPhamCT().getGia() * hdct.getSoLuong();
        }
        if (idHDSelect == null) {
            if (listHD.size() > 0) {
                idHDSelect = listHD.get(0).getId();
            }
        } else {
            HoaDon hd = sv.detail(idHDSelect);
            if (hd.getVoucher() != null) {
                tongTien = sum - (sum / 100 * hd.getVoucher().getGiaTri());
            } else {
                tongTien = sum;
            }
        }

        HoaDon hd1 = sv.detail(idHDSelect);
        KhachHang kh = sv.layKHchoHD(idHDSelect);
        Voucher v = sv.layVCchoHD(idHDSelect);
        listHDCT = svHDCT.getListHD(idHDSelect);
        model.addAttribute("tamTinh", sum);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("idHDSelect", idHDSelect);
        model.addAttribute("kh", kh);
        model.addAttribute("v", v);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listV", listV);
        model.addAttribute("listHD", listHD);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("hd", new HoaDon());
        model.addAttribute("errorSL", errorSL);
        model.addAttribute("hd1", hd1);

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
    public String update(@RequestParam("tamTinh") Double tamTinh, @RequestParam("tongTien") Double tongTien) {
        HoaDon hd = sv.detail(idHDSelect);
        hd.setTinhTrang(1);
        hd.setNgayThanhToan(new java.util.Date());
        hd.setThanhTien(tamTinh);
        hd.setTongTien(tongTien);
        if (hd.getKhachHang() == null) {
            hd.setKhachHang(sv.KHL());
        }
        sv.add(hd);
        idHDSelect = null;
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @PostMapping("/hoa-don/huy")
    public String huy() {
        HoaDon hd1 = sv.detail(idHDSelect);
        listHDCT = svHDCT.getListHD(idHDSelect);
        if (listHDCT != null) {
            for (HoaDonChiTiet hdct : listHDCT) {
                SanPhamChiTiet sanPhamChiTiet = serviceSPCT.detail(hdct.getSanPhamCT().getId());
                sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() + hdct.getSoLuong());
                serviceSPCT.save(sanPhamChiTiet);
            }
        }
        hd1.setTinhTrang(2);
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
                if (spct.getSoLuong() - 1 < 0) {
                    return false;
                }
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

    @PostMapping("/hoa-don/them-san-pham-qr")
    public String themSPQR(@RequestBody UUID spctID, Model model) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        HoaDon hd = sv.detail(idHDSelect);
        SanPhamChiTiet spct = serviceSPCT.detail(spctID);
        listHDCT = svHDCT.getListHD(idHDSelect);
        if (kiemTra(listHDCT, spctID)) {
            if (spct.getSoLuong() - 1 < 0) {
                return "redirect:/tao-hoa-don/hien-thi";
            }
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

    @PostMapping("/hoa-don/them-voucher")
    public String addVC(@RequestParam("VCID") UUID vcid) {
        HoaDon hd = sv.detail(idHDSelect);
        if (hd.getVoucher() != null) {
            Optional<Voucher> vcc = voucherRepository.findById(hd.getVoucher().getId());
            vcc.get().setSoLuong(vcc.get().getSoLuong() + 1);
        }
        Optional<Voucher> vc = voucherRepository.findById(vcid);
        vc.get().setSoLuong(vc.get().getSoLuong() - 1);
        hd.setVoucher(vc.get());
        sv.add(hd);
        return "redirect:/tao-hoa-don/hien-thi";
    }

    @GetMapping("/huy/voucher")
    public String huyvc() {
        HoaDon hd = sv.detail(idHDSelect);
        if (hd.getVoucher() != null) {
            Optional<Voucher> vcc = voucherRepository.findById(hd.getVoucher().getId());
            vcc.get().setSoLuong(vcc.get().getSoLuong() + 1);
        }
        hd.setVoucher(null);
        sv.add(hd);
        return "redirect:/tao-hoa-don/hien-thi";
    }
}
