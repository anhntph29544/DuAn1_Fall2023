package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_nhan_vien")
    private UUID idNhanVien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chuc_vu", referencedColumnName = "id_chuc_vu")
    private ChucVu chucVu;

    @NotEmpty(message = "Mã không được để trống")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Mã không hợp lệ, chỉ được chứa chữ cái và số")
    @Column(name = "ma")
    private String ma;

    @NotEmpty(message = "Họ và tên không được để trống")
    @Size(min = 2, max = 50, message = "Họ và tên phải có độ dài từ 3 đến 50 ký tự")
    @Pattern(regexp = "^[A-Za-zÀ-ỹ ]+$", message = "Họ và tên không hợp lệ")
    @Column(name = "ho_ten")
    private String hoTen;

    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@fpt\\.edu\\.vn$", message = "Email phải có đuôi @fpt.edu.vn")
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{12}$", message = "CCCD phải có 12 chữ số")
    @Column(name = "cccd")
    private String cccd;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "huyen")
    private String huyen;

    @Column(name = "xa")
    private String xa;

    @Column(name = "so_nha")
    private String soNha;

    @Column(name = "sdt")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Số điện thoại phải có từ 10 đến 11 chữ số")
    private String sdt;

    @Column(name = "image")
    private String image;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
