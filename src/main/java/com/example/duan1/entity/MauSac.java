package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name="mau_sac")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_mau_sac")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    @NotBlank(message = "Không được trống")
    private String ten;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @Column(name = "ngay_them")
    private Date ngayThem;
}
