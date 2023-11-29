package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voucher")
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_voucher")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "gia_tri")
    private int giaTri;

    @Column(name = "ngay_bat_dau")
    private java.sql.Date ngayBD;

    @Column(name = "ngay_ket_thuc")
    private java.sql.Date ngayKT;

    @Column(name = "trang_thai")
    private int trangThai;
}
