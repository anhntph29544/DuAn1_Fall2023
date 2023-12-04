package com.example.duan1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voucher")
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_voucher")
    private UUID id;

    @Column(name = "ma")
    @NotEmpty(message = "Không được trống")
    private String ma;

    @Column(name = "so_luong")
    @NotEmpty(message = "Không được trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private String soLuong;

    @Column(name = "gia_tri")
    @NotEmpty(message = "Không được trống")
    @Range(min = 1, max = 100, message = "Giá trị phải nằm trong khoảng từ 1 đến 100")
    private String giaTri;

    @Column(name = "ngay_bat_dau")
//    @NotEmpty(message = "Không được trống")
    private java.sql.Date ngayBD;

    @Column(name = "ngay_ket_thuc")
//    @NotNull(message = "Không được trống")
//    @Future(message = "Ngày kết thúc phải ở tương lai")
    private java.util.Date ngayKT;

    @Column(name = "trang_thai")
    private int trangThai;
}
