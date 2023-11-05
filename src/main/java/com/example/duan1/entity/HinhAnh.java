package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "hinh_anh")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_hinh_anh")
    private UUID idHinhAnh;

    @Column(name = "ten")
    private String ten;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "mac_dinh")
    private String macDinh;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "tao_luc")
    private Date createdAt;

    @Column(name = "sua_luc")
    private Date updatedAt;

    @Column(name = "tao_boi")
    private UUID createdBy;

    @Column(name = "sua_boi")
    private Date updatedy;

    @Column(name = "da_xoa")
    private String deleted;
}
