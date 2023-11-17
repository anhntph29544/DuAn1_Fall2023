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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "hoa_don")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_hoa_don")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien", referencedColumnName = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_kh", referencedColumnName = "id_kh")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_voucher", referencedColumnName = "id_voucher")
    private Voucher voucher;

    @Column(name = "ma")
    private String ma;

    @Column(name = "loai_hoa_don")
    private Integer loai;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(name = "thanh_tien")
    private Double thanhTien;

}
