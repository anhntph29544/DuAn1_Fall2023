package com.example.duan1.repository;

import com.example.duan1.entity.HoaDon;
import com.example.duan1.entity.HoaDonChiTiet;
import com.example.duan1.entity.KhachHang;
import com.example.duan1.entity.SanPham;
import com.example.duan1.entity.Voucher;
import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd where hd.ngayThanhToan between ?1 and ?2  ")
    Double tinhTongTienTheoNgay(Date ngayThanhToan1,Date ngayThanhToan2);

    @Query("Select hd from HoaDon hd where hd.tinhTrang=0 order by hd.ngayThem asc")
    List<HoaDon> CTT();

    @Query("Select hd from HoaDon hd where hd.tinhTrang=?1 order by hd.ngayThem asc")
    List<HoaDon> ttHD(Integer trangThai);

    @Query("SELECT hd from HoaDon hd where hd.ngayThem between ?1 and ?2 order by hd.ngayThem")
    List<HoaDon> search(Date ngayBD, Date ngayKT);

    @Query("SELECT hd from HoaDon hd where hd.ngayThem between ?1 and ?2 and hd.tinhTrang=?3 order by hd.ngayThem")
    List<HoaDon> search2(Date ngayBD, Date ngayKT, Integer tinhTrang);

    @Query("select hd from HoaDon hd where hd.khachHang.email = ?1 or hd.khachHang.sdt=?1")
    KhachHang search(String email);

    @Query("select kh from KhachHang kh where kh.ma='KH00' ")
    KhachHang searchKHL();

    @Query("select hd from HoaDon hd order by hd.ngayThem desc ")
    List<HoaDon> getNgay();

    @Query("select hd from HoaDon hd order by hd.ngayThanhToan desc")
    List<HoaDon> sortList();

    @Query("select hd.ma from HoaDon hd")
    List<String> maHD();

    @Query("select hd.khachHang from HoaDon hd where hd.id=?1 ")
    KhachHang chonKHchoHd(UUID id);

    @Query("select hd.voucher from HoaDon hd where hd.id=?1 ")
    Voucher chonVCchoHd(UUID id);

    @Query("select hd from HoaDon hd where hd.voucher.id = ?1")
    List<HoaDon> getListHDdc(UUID id);
}
