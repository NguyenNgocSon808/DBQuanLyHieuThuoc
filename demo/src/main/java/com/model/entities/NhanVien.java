package com.model.entities;

import java.util.Date;

public class NhanVien {
    private String idnv;
    private String hoTen;
    private String sdt;
    private String gioiTinh;
    private String vaiTro;
    private int namSinh;
    private Date ngayVaoLam;

    public NhanVien() {}

    public NhanVien(String idnv, String hoTen, String sdt, String gioiTinh, String vaiTro, int namSinh, Date ngayVaoLam) {
        this.idnv = idnv;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.vaiTro = vaiTro;
        this.namSinh = namSinh;
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getIdnv() { return idnv; }
    public void setIdnv(String idnv) { this.idnv = idnv; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
    public int getNamSinh() { return namSinh; }
    public void setNamSinh(int namSinh) { this.namSinh = namSinh; }
    public Date getNgayVaoLam() { return ngayVaoLam; }
    public void setNgayVaoLam(Date ngayVaoLam) { this.ngayVaoLam = ngayVaoLam; }
}
