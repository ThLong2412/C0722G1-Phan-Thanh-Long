package exam.model;

import exam.service.ITaiKhoanThanhToanService;

import java.time.LocalDate;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private String soThe;
    private String soTienTrongTaiKhoan;

    public TaiKhoanThanhToan(){}

    public TaiKhoanThanhToan(int idTaiKhoan, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTaoTaiKhoan, String soThe, String soTienTrongTaiKhoan) {
        super(idTaiKhoan, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(String soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" + super.toString() +
                ", soThe='" + soThe + '\'' +
                ", soTienTrongTaiKhoan='" + soTienTrongTaiKhoan + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",getIdTaiKhoan(),getMaTaiKhoan(),getTenTaiKhoan(),getNgayTaoTaiKhoan(),getSoThe(),getSoTienTrongTaiKhoan());
    }


}
