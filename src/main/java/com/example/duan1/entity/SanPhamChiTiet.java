package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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
    @Column(name = "id_spct")
    private UUID id;

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
    @JoinColumn(name = "id_mau_sac",referencedColumnName = "id_mau_sac")
    private MauSac ms;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu",referencedColumnName = "id_thuong_hieu")
    private ThuongHieu th;

    @ManyToOne
    @JoinColumn(name = "id_san_pham",referencedColumnName = "id_san_pham")
    private SanPham sp;

    @Column(name = "ma")
    @NotBlank(message = "khong duoc rong")
    private String ma;

    @Column(name = "mo_ta")
    @NotBlank(message = "khong duoc rong")
    private String moTa;

    @Column(name = "so_luong_ton")
    @NotBlank(message = "khong duoc rong")
    private String soLuong;

    @Column(name = "gia")
    @NotNull(message = "khong duoc rong")
    private Double gia;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
