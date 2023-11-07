package com.example.duan1.repository;

import com.example.duan1.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {

    @Query("SELECT e FROM ThuongHieu e where e.ten like 'KH09'")
    Page<ThuongHieu> search(Pageable pageable,String ten);

}
