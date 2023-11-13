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

import java.util.UUID;

@Entity
@Table(name = "hoa_don_chi_tiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_hoa_don_chi_tiet")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don", referencedColumnName = "id_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "id_spct", referencedColumnName = "id_spct")
    private SanPhamChiTiet sanPhamCT;


    @Column(name = "gia")
    private Double gia;

    @Column(name = "so_luong")

    private Integer soLuong;

    @Column(name = "trang_thai")
    private Integer donGia;
}
