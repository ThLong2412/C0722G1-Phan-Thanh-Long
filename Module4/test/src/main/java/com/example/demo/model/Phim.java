package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String ten;

    @OneToMany(mappedBy = "phim")
    public Set<SuatChieu> suatChieus;

    public void setSuatChieus(Set<SuatChieu> suatChieus) {
        this.suatChieus = suatChieus;
    }

    public Phim() {
    }

    public Phim(Long id, String ten, Set<SuatChieu> suatChieus) {
        this.id = id;
        this.ten = ten;
        this.suatChieus = suatChieus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<SuatChieu> getSuatChieus() {
        return suatChieus;
    }
}
