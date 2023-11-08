package com.example.demo.entity;

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

@Entity
@Table(name = "khung_xe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhungXe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_khung_xe")
    private String id;

    @Column(name = "ma")
    @NotBlank(message = "khong duoc trong")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "khong duoc trong")
    private String ten;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
