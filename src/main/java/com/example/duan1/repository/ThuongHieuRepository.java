package com.example.duan1.repository;

import com.example.duan1.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {

    @Query("SELECT e FROM ThuongHieu e where e.ten like %?1%")
    List<ThuongHieu> search(String ten);

}
