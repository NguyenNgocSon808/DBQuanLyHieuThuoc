package com.model.dao;

import com.model.entities.HoaDon;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO implements InterfaceDAO<HoaDon, String> {
    @Override
    public void create(HoaDon hd) {
        String sql = "INSERT INTO hoadon (idhd, tongtien, thoigiantao, thoigiannhan, idnv, idkh) VALUES (?, ?, ?, ?, ?, ?)";
        DatabaseConnection.update(sql, hd.getIdhd(), hd.getTongTien(), new java.sql.Timestamp(hd.getThoiGianTao().getTime()), hd.getThoiGianNhan() != null ? new java.sql.Timestamp(hd.getThoiGianNhan().getTime()) : null, hd.getIdnv(), hd.getIdkh());
    }

    @Override
    public void update(HoaDon hd) {
        String sql = "UPDATE hoadon SET tongtien=?, thoigiantao=?, thoigiannhan=?, idnv=?, idkh=? WHERE idhd=?";
        DatabaseConnection.update(sql, hd.getTongTien(), new java.sql.Timestamp(hd.getThoiGianTao().getTime()), hd.getThoiGianNhan() != null ? new java.sql.Timestamp(hd.getThoiGianNhan().getTime()) : null, hd.getIdnv(), hd.getIdkh(), hd.getIdhd());
    }

    @Override
    public void deleteById(String idhd) {
        String sql = "DELETE FROM hoadon WHERE idhd=?";
        DatabaseConnection.update(sql, idhd);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new HoaDon(
                    rs.getString("idhd"),
                    rs.getDouble("tongtien"),
                    rs.getTimestamp("thoigiantao"),
                    rs.getTimestamp("thoigiannhan"),
                    rs.getString("idnv"),
                    rs.getString("idkh")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql("SELECT * FROM hoadon");
    }

    @Override
    public HoaDon selectById(String idhd) {
        List<HoaDon> list = selectBySql("SELECT * FROM hoadon WHERE idhd = ?", idhd);
        return list.isEmpty() ? null : list.get(0);
    }
}
