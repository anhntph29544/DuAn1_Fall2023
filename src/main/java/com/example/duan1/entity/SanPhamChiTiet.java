package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @JoinColumn(name = "id_mau_sac",referencedColumnName = "id_mau_sac")
    private MauSac ms;

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
    @NotNull(message = "Không được trống")
    @Min(value = 0, message = "Số lượng phải >=0")
    @Pattern(regexp = "[0-9]+", message = "Số lượng phải là số nguyên dương")
    private String soLuong;

    @Column(name = "gia")
    @NotNull(message = "Không được trống")
    @Min(value = 0, message = "Đơn giá phải >=0")
    private Double gia;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "hinh_anh")
    private String hinhAnh;

}
