package com.example.duan1.controller;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.entity.KieuDangXe;
import com.example.duan1.entity.MauSac;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.SanPhamChiTiet;
import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.service.KichThuocService;
import com.example.duan1.service.KieuDangXeService;
import com.example.duan1.service.MauSacSV;
import com.example.duan1.service.SanPhamChiTietService;
import com.example.duan1.service.SanPhamService;
import com.example.duan1.service.ThuongHieuService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@Controller
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietService serviceSPCT;
    private Page<SanPhamChiTiet> listSPCT;
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
    private List<KichThuoc> listKT= new ArrayList<>();
    private List<KieuDangXe> listKDX= new ArrayList<>();
    private List<MauSac> listMS= new ArrayList<>();
    private List<SanPham> listSP= new ArrayList<>();
    private List<ThuongHieu> listTH= new ArrayList<>();
    private SanPhamChiTiet spct = new SanPhamChiTiet();
    private int messege=0;

    @GetMapping("/shop-xe/san-pham-chi-tiet/hien-thi")
    public String hienThi(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "tenSearch",defaultValue = "") String ten,
                          @RequestParam(value = "trangThai",defaultValue = "3")Integer trangThai,
                          Model model){
        listSPCT= serviceSPCT.getData(page);
        combobox(model);
        if(!ten.trim().isEmpty()){
            listSPCT= serviceSPCT.searchPage(ten.trim(),trangThai, page);
            model.addAttribute("tenSearch", ten.trim());
        }else if(trangThai!=3){
            listSPCT= serviceSPCT.searchPage(ten.trim(),trangThai, page);
        }
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("messege",messege);
        model.addAttribute("listSPCT", listSPCT);
        messege=0;
        return "/sanpham/sanphams";
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/view-add")
    public String viewAdd(Model model){
        model.addAttribute("spct1", new SanPhamChiTiet());
        combobox(model);
        return "/sanpham/spct-add";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/add")
    public String add(@Valid @ModelAttribute("spct1")SanPhamChiTiet spct1,
                      BindingResult result,
                      @RequestParam("photo") MultipartFile photo,
                      Model model){
        if(result.hasErrors()){
            combobox(model);
            model.addAttribute("listSPCT", listSPCT);
            return "/sanpham/spct-add";
        }
        Path path = Paths.get("upload/");
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream,path.resolve(photo.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            spct1.setHinhAnh(photo.getOriginalFilename().toLowerCase());
        }catch (Exception e){
            e.printStackTrace();
        }
        spct1.setMa(serviceSPCT.tuTaoMa());
        Boolean save = serviceSPCT.save(spct1);
        if(save){
            messege=1;
        }else {
            messege=2;
        }
        return "redirect:/shop-xe/san-pham-chi-tiet/hien-thi";
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        spct = serviceSPCT.detail(id);
        combobox(model);
        model.addAttribute("spct1",spct);
        return "/sanpham/spct-update";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/update")
    public String update(@Valid @ModelAttribute("spct1")SanPhamChiTiet spct1,
                         @RequestParam("photo") MultipartFile photo,
                         BindingResult result,
                         Model model){
        if(result.hasErrors()){
            combobox(model);
            return "/sanpham/spct-update";
        }
        Path path = Paths.get("upload/");
        if(photo.getOriginalFilename().isEmpty()){
            spct1.setHinhAnh(spct.getHinhAnh());
        }else{
            try {
                InputStream inputStream = photo.getInputStream();
                Files.copy(inputStream,path.resolve(photo.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
                spct1.setHinhAnh(photo.getOriginalFilename().toLowerCase());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        spct1.setId(spct.getId());
        spct1.setMa(spct.getMa());
        Boolean save = serviceSPCT.save(spct1);
        if(save){
            messege=1;
        }else {
            messege=2;
        }
        return "redirect:/shop-xe/san-pham-chi-tiet/hien-thi";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/sp/add")
    public ResponseEntity addSP(@Valid @ModelAttribute("sp1") SanPham sp1, Model model){
        serviceSP.save(sp1);
        combobox(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/ms/add")
    public String addMS(@Valid @ModelAttribute("ms1") MauSac ms1,
                        BindingResult result,  Model model){
        serviceMS.save(ms1);
        return "redirect:/shop-xe/san-pham-chi-tiet/view-add";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/kdx/add")
    public String addKDX(@Valid @ModelAttribute("kdx1") KieuDangXe kdx1,
                        BindingResult result, Model model){
        serviceKDX.save(kdx1);
        return "redirect:/shop-xe/san-pham-chi-tiet/view-add";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/kt/add")
    public String addKT(@Valid @ModelAttribute("kt1") KichThuoc kt1,
                         BindingResult result, Model model){
        serviceKT.save(kt1);
        return "redirect:/shop-xe/san-pham-chi-tiet/view-add";
    }

    @PostMapping("/shop-xe/san-pham-chi-tiet/th/add")
    public String addTH(@Valid @ModelAttribute("th1") ThuongHieu th1,
                        BindingResult result, Model model){
        serviceTH.save(th1);
        return "redirect:/shop-xe/san-pham-chi-tiet/view-add";
    }

    @GetMapping("/shop-xe/san-pham-chi-tiet/detail/{id}")
    public String detail(@PathVariable("id")UUID id, Model model){
        SanPhamChiTiet spct = serviceSPCT.detail(id);
        combobox(model);
        model.addAttribute("listSPCT", listSPCT);
        model.addAttribute("spct1",spct);
        return "/sanpham/hien-thi";
    }

    public void combobox(Model model){
        listKT= serviceKT.getAll();
        listKDX= serviceKDX.getAll();
        listMS= serviceMS.getAll();
        listSP= serviceSP.getAll();
        listTH= serviceTH.getAll();
        model.addAttribute("listKT",listKT);
        model.addAttribute("listKDX",listKDX);
        model.addAttribute("listMS",listMS);
        model.addAttribute("listSP",listSP);
        model.addAttribute("listTH",listTH);
    }

}
