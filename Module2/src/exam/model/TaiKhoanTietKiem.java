package exam.model;

import exam.service.ITaiKhoanTietKiemService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private String soTienGui;
    private LocalDate ngayGui;
    private String laiSuat;
    private String kiHan;

    public TaiKhoanTietKiem() {

    }

    public TaiKhoanTietKiem(int idTaiKhoan, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTaoTaiKhoan, String soTienGui, LocalDate ngayGui, String laiSuat, String kiHan) {
        super(idTaiKhoan, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" + super.toString() +
                ", soTienGui='" + soTienGui + '\'' +
                ", ngayGui=" + ngayGui +
                ", laiSuat='" + laiSuat + '\'' +
                ", kiHan='" + kiHan + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getIdTaiKhoan(),getMaTaiKhoan(),getTenTaiKhoan(),getNgayTaoTaiKhoan(),getSoTienGui(),getNgayGui(),getLaiSuat(),getKiHan());
    }

}
