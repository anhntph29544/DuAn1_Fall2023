package com.example.duan1.repository;

import com.example.duan1.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, UUID> {

    @Query("select kt from KichThuoc kt where kt.ten like %?1%")
    List<KichThuoc> search(String ten);

    @Query("select kt from KichThuoc kt order by kt.ngayThem desc")
    List<KichThuoc> sort();

    @Query("select kt.ma from KichThuoc kt")
    List<String> maKT();

}
