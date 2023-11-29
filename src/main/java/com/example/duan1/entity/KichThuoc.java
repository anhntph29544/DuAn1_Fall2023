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
@Table(name = "kich_thuoc")
@Entity
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_kich_thuoc")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "Không được trống")
    private String ten;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "ngay_them")
    private Date ngayThem;

}