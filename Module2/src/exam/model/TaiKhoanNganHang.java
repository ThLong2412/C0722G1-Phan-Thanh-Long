package exam.model;

import java.time.LocalDate;

public abstract class TaiKhoanNganHang {

    private int idTaiKhoan;
    private String maTaiKhoan;
    private String tenTaiKhoan;
    private LocalDate ngayTaoTaiKhoan;
    public TaiKhoanNganHang() {}


    public TaiKhoanNganHang(int idTaiKhoan, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTaoTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public LocalDate getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(LocalDate ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return
                "id='" + idTaiKhoan + '\'' +
                ", code='" + maTaiKhoan + '\'' +
                ", name='" + tenTaiKhoan + '\'' +
                ", dayStart=" + ngayTaoTaiKhoan
                ;
    }
    public abstract String getInfo();
}
