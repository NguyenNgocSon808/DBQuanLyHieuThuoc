package com.model.entities;

public class ChiTietPhieuNhap {
    private String idPhieu;
    private String idThuoc;
    private int soLuong;
    private double giaNhap;

    public ChiTietPhieuNhap() {}

    public ChiTietPhieuNhap(String idPhieu, String idThuoc, int soLuong, double giaNhap) {
        this.idPhieu = idPhieu;
        this.idThuoc = idThuoc;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    public String getIdPhieu() { return idPhieu; }
    public void setIdPhieu(String idPhieu) { this.idPhieu = idPhieu; }
    public String getIdThuoc() { return idThuoc; }
    public void setIdThuoc(String idThuoc) { this.idThuoc = idThuoc; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getGiaNhap() { return giaNhap; }
    public void setGiaNhap(double giaNhap) { this.giaNhap = giaNhap; }
}
