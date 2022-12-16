package com.example.demo.dto;

import com.example.demo.model.Phim;
import com.example.demo.model.SuatChieu;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SuatChieuDto implements Validator {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[C][I][-][0-9]{4}$", message = "Mã suất chiếu phải đúng định dạng CI-XXXX(X: số nguyên dương)")
    private String maChieuSuat;
    private String ngay;
    @Min(value = 0, message = "Số lượng vé phải lớn hơn 0")
    private Integer soLuong;
    @ManyToOne
    private Phim phim;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SuatChieuDto suatChieu = (SuatChieuDto) target;
        LocalDate ngayTest = LocalDate.parse(suatChieu.getNgay(), formatter);
        LocalDate date = LocalDate.now();
        long day = ngayTest.until(date, ChronoUnit.DAYS);
        if (day < 0) {
            errors.rejectValue("ngay", "ngay", "Ngày phải sau ngày hiện tại");
        }
    }

    public SuatChieuDto() {
    }

    public SuatChieuDto(Long id, @Pattern(regexp = "^[C][I][-][0-9]{4}$", message = "Mã suất chiếu phải đúng định dạng CI-XXXX(X: số nguyên dương)") String maChieuSuat, String ngay, @Min(0) Integer soLuong, Phim phim) {
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
