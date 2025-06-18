package com.model.entities;

import java.util.Date;

public class PhieuNhapHang {
    private String idPhieu;
    private Date thoiGian;
    private String idnv;
    private String idncc;
    private String tenNhapHang;
    private double tongTien;

    public PhieuNhapHang() {}

    public PhieuNhapHang(String idPhieu, Date thoiGian, String idnv, String idncc, String tenNhapHang, double tongTien) {
        this.idPhieu = idPhieu;
        this.thoiGian = thoiGian;
        this.idnv = idnv;
        this.idncc = idncc;
        this.tenNhapHang = tenNhapHang;
        this.tongTien = tongTien;
    }

    public String getIdPhieu() { return idPhieu; }
    public void setIdPhieu(String idPhieu) { this.idPhieu = idPhieu; }
    public Date getThoiGian() { return thoiGian; }
    public void setThoiGian(Date thoiGian) { this.thoiGian = thoiGian; }
    public String getIdnv() { return idnv; }
    public void setIdnv(String idnv) { this.idnv = idnv; }
    public String getIdncc() { return idncc; }
    public void setIdncc(String idncc) { this.idncc = idncc; }
    public String getTenNhapHang() { return tenNhapHang; }
    public void setTenNhapHang(String tenNhapHang) { this.tenNhapHang = tenNhapHang; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}
