package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "san_pham_chi_tiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_bo_chuyen_dong",referencedColumnName = "id_bo_chuyen_dong")
    private BoChuyenDong bcd;

    @ManyToOne
    @JoinColumn(name = "id_ghi_dong",referencedColumnName = "id_ghi_dong")
    private GhiDong gd;

    @ManyToOne
    @JoinColumn(name = "id_phanh",referencedColumnName = "id_phanh")
    private Phanh p;

    @ManyToOne
    @JoinColumn(name = "id_khung_xe",referencedColumnName = "id_khung_xe")
    private KhungXe kx;

    @ManyToOne
    @JoinColumn(name = "id_kieu_dang_xe",referencedColumnName = "id_kieu_dang_xe")
    private KieuDangXe kdx;

    @ManyToOne
    @JoinColumn(name = "id_kich_thuoc",referencedColumnName = "id_kich_thuoc")
    private KichThuoc kt;

    @ManyToOne
    @JoinColumn(name = "id_hinh_anh",referencedColumnName = "id_hinh_anh")
    private HinhAnh ha;

    @ManyToOne
    @JoinColumn(name = "id_lop_xe",referencedColumnName = "id_lop_xe")
    private LopXe lx;

    @ManyToOne
    @JoinColumn(name = "id_ban_dap",referencedColumnName = "id_ban_dap")
    private BanDap bd;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac",referencedColumnName = "id_mau_sac")
    private MauSac ms;

    @ManyToOne
    @JoinColumn(name = "id_nsx",referencedColumnName = "id_nsx")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu",referencedColumnName = "id_thuong_hieu")
    private ThuongHieu th;

    @ManyToOne
    @JoinColumn(name = "id_san_pham",referencedColumnName = "id_san_pham")
    private SanPham sp;

    @Column(name = "ma")
    private String ma;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "so_luong_ton")
    private String soLuong;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
