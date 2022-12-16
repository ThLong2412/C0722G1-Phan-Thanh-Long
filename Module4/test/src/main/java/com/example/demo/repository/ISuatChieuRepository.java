package com.example.demo.repository;

import com.example.demo.model.SuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ISuatChieuRepository extends JpaRepository<SuatChieu, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from suat_chieu where suat_chieu.ma_chieu_suat like concat('%',:maChieusuat,'%')", nativeQuery = true)
    void remove(@Param("maChieusuat") String maChieusuat);
}
