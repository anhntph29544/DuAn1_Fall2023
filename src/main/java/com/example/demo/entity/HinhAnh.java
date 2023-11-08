package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "mac_dinh")
    private String macDinh;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
