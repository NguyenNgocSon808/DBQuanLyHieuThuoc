package com.model.entities;

public class ChiTietHoaDon {
    private String idhd;
    private String idThuoc;
    private int soLuong;
    private double donGia;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(String idhd, String idThuoc, int soLuong, double donGia) {
        this.idhd = idhd;
        this.idThuoc = idThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdhd() { return idhd; }
    public void setIdhd(String idhd) { this.idhd = idhd; }
    public String getIdThuoc() { return idThuoc; }
    public void setIdThuoc(String idThuoc) { this.idThuoc = idThuoc; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
}
