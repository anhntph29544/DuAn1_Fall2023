package com.example.duan1.repository;


import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface VoucherRepository extends JpaRepository<Voucher, UUID> {
    @Query("SELECT e FROM Voucher  e where (:ngayBD is null or :ngayBD like '' or e.ngayBD >= :ngayBD) and (:ngayKT is null or :ngayKT like '' or e.ngayKT <= :ngayKT)")
    List<Voucher> search(String ngayBD,String ngayKT);
    @Query("Select vc from Voucher vc where vc.trangThai=0")
    public List<Voucher> getHD();

}
