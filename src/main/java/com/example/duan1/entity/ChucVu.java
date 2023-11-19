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

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "chuc_vu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChucVu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_chuc_vu")
    private UUID idChucVu;

    @Column(name = "ma")
    private String maChucVu;

    @Column(name = "ten")
    private String tenChucVu;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
