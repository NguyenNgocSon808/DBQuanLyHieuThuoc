package com.model.entities;

public class Thuoc {
    private String idThuoc;
    private String ten;
    private String thanhPhan;
    private String donViTinh;
    private String danhMuc;
    private String xuatXu;
    private double giaNhap;
    private double giaBan;
    private int soLuongTon;

    public Thuoc() {}

    public Thuoc(String idThuoc, String ten, String thanhPhan, String donViTinh, String danhMuc, String xuatXu, double giaNhap, double giaBan, int soLuongTon) {
        this.idThuoc = idThuoc;
        this.ten = ten;
        this.thanhPhan = thanhPhan;
        this.donViTinh = donViTinh;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
    }

    public String getIdThuoc() { return idThuoc; }
    public void setIdThuoc(String idThuoc) { this.idThuoc = idThuoc; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public String getThanhPhan() { return thanhPhan; }
    public void setThanhPhan(String thanhPhan) { this.thanhPhan = thanhPhan; }
    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { this.donViTinh = donViTinh; }
    public String getDanhMuc() { return danhMuc; }
    public void setDanhMuc(String danhMuc) { this.danhMuc = danhMuc; }
    public String getXuatXu() { return xuatXu; }
    public void setXuatXu(String xuatXu) { this.xuatXu = xuatXu; }
    public double getGiaNhap() { return giaNhap; }
    public void setGiaNhap(double giaNhap) { this.giaNhap = giaNhap; }
    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }
    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
}
