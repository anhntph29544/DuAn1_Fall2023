package com.example.duan1.repository;

import com.example.duan1.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    @Query("select ms from MauSac ms where ms.ten like %?1%")
    List<MauSac> search(String ten);


}
