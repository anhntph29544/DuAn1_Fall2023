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

import java.util.UUID;

@Entity
@Table(name = "ghi_dong")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GhiDong {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_ghi_dong")
    private UUID id;

    @Column(name = "ma")
    @NotBlank(message = "Không được trống")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "Không được trống")
    private String ten;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
