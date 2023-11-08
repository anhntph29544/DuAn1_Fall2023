package com.example.duan1.repository;

import com.example.duan1.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {

    @Query("select sp from SanPham sp where sp.ten like %?1%")
    List<SanPham> search(String ten);

}
