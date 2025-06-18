package com.model.entities;

import java.util.Date;

public class HoaDon {
    private String idhd;
    private double tongTien;
    private Date thoiGianTao;
    private Date thoiGianNhan;
    private String idnv;
    private String idkh;

    public HoaDon() {}

    public HoaDon(String idhd, double tongTien, Date thoiGianTao, Date thoiGianNhan, String idnv, String idkh) {
        this.idhd = idhd;
        this.tongTien = tongTien;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianNhan = thoiGianNhan;
        this.idnv = idnv;
        this.idkh = idkh;
    }

    public String getIdhd() { return idhd; }
    public void setIdhd(String idhd) { this.idhd = idhd; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    public Date getThoiGianTao() { return thoiGianTao; }
    public void setThoiGianTao(Date thoiGianTao) { this.thoiGianTao = thoiGianTao; }
    public Date getThoiGianNhan() { return thoiGianNhan; }
    public void setThoiGianNhan(Date thoiGianNhan) { this.thoiGianNhan = thoiGianNhan; }
    public String getIdnv() { return idnv; }
    public void setIdnv(String idnv) { this.idnv = idnv; }
    public String getIdkh() { return idkh; }
    public void setIdkh(String idkh) { this.idkh = idkh; }
}
