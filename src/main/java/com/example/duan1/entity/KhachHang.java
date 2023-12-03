package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_kh")
    private UUID idKhachHang;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String hoTen;
    ;

    @Column(name = "image")
    private String image;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "email")
    private String email;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "huyen")
    private String huyen;

    @Column(name = "xa")
    private String xa;
    @Column(name = "cccd")
    private String cccd;
    @Column(name = "so_nha")
    private String soNha;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "trang_thai")
    private Integer trangThai;
}