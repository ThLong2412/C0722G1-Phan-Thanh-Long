package model;

public class BenhNhan {
    private int id;
    private String idBenhNhan;
    private String tenBenhNhan;

    public BenhNhan() {
    }

    public BenhNhan(int id, String idBenhNhan, String tenBenhNhan) {
        this.id = id;
        this.idBenhNhan = idBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(String idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }
}
