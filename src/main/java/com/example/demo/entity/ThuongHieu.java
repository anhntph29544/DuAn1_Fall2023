package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "thuong_hieu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_thuong_hieu")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
