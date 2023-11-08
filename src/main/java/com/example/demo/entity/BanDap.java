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

import java.util.UUID;

@Entity
@Table(name = "ban_dap")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BanDap {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_ban_dap")
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
