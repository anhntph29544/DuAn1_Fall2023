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

@Entity
@Table(name = "kieu_dang_xe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KieuDangXe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_kieu_dang_xe")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "khong duoc trong")
    private String ten;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_them")
    private Date ngayThem;

}
