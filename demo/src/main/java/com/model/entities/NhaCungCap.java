package com.model.entities;

public class NhaCungCap {
    private String idncc;
    private String tenNhaCungCap;
    private String sdt;
    private String diaChi;

    public NhaCungCap() {}

    public NhaCungCap(String idncc, String tenNhaCungCap, String sdt, String diaChi) {
        this.idncc = idncc;
        this.tenNhaCungCap = tenNhaCungCap;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getIdncc() { return idncc; }
    public void setIdncc(String idncc) { this.idncc = idncc; }
    public String getTenNhaCungCap() { return tenNhaCungCap; }
    public void setTenNhaCungCap(String tenNhaCungCap) { this.tenNhaCungCap = tenNhaCungCap; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}
