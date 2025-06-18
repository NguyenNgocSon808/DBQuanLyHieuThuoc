package com.model.entities;

public class KhachHang {
    private String id;
    private String hoTen;
    private String sdt;
    private String gioiTinh;
    private String idtk;

    public KhachHang() {}

    public KhachHang(String id, String hoTen, String sdt, String gioiTinh, String idtk) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.idtk = idtk;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    public String getIdtk() { return idtk; }
    public void setIdtk(String idtk) { this.idtk = idtk; }
}
