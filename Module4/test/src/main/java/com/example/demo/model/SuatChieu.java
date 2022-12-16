package com.example.demo.model;

import javax.persistence.*;

@Entity
public class SuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String maChieuSuat;
     private String ngay;
   private Integer soLuong;

    @ManyToOne
    private Phim phim;

    public SuatChieu() {
    }

    public SuatChieu(Long id, String maChieuSuat, String ngay, Integer soLuong, Phim phim) {
        this.id = id;
        this.maChieuSuat = maChieuSuat;
        this.ngay = ngay;
        this.soLuong = soLuong;
        this.phim = phim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaChieuSuat() {
        return maChieuSuat;
    }

    public void setMaChieuSuat(String maChieuSuat) {
        this.maChieuSuat = maChieuSuat;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }
}
