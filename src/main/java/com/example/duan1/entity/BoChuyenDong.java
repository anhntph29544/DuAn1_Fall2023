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

import java.util.UUID;

@Table(name = "bo_chuyen_dong")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoChuyenDong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_bo_chuyen_dong")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "trang_thai")
    private Integer trangThai;
}