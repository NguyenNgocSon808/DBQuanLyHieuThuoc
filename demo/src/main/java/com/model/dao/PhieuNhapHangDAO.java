package com.model.dao;

import com.model.entities.PhieuNhapHang;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapHangDAO implements InterfaceDAO<PhieuNhapHang, String> {
    @Override
    public void create(PhieuNhapHang pnh) {
        String sql = "INSERT INTO phieunhaphang (idphieu, thoigian, idnv, idncc, tennhaphang, tongtien) VALUES (?, ?, ?, ?, ?, ?)";
        DatabaseConnection.update(sql, pnh.getIdPhieu(), new java.sql.Timestamp(pnh.getThoiGian().getTime()), pnh.getIdnv(), pnh.getIdncc(), pnh.getTenNhapHang(), pnh.getTongTien());
    }

    @Override
    public void update(PhieuNhapHang pnh) {
        String sql = "UPDATE phieunhaphang SET thoigian=?, idnv=?, idncc=?, tennhaphang=?, tongtien=? WHERE idphieu=?";
        DatabaseConnection.update(sql, new java.sql.Timestamp(pnh.getThoiGian().getTime()), pnh.getIdnv(), pnh.getIdncc(), pnh.getTenNhapHang(), pnh.getTongTien(), pnh.getIdPhieu());
    }

    @Override
    public void deleteById(String idPhieu) {
        String sql = "DELETE FROM phieunhaphang WHERE idphieu=?";
        DatabaseConnection.update(sql, idPhieu);
    }

    @Override
    public List<PhieuNhapHang> selectBySql(String sql, Object... args) {
        List<PhieuNhapHang> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new PhieuNhapHang(
                    rs.getString("idphieu"),
                    rs.getTimestamp("thoigian"),
                    rs.getString("idnv"),
                    rs.getString("idncc"),
                    rs.getString("tennhaphang"),
                    rs.getDouble("tongtien")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<PhieuNhapHang> selectAll() {
        return selectBySql("SELECT * FROM phieunhaphang");
    }

    @Override
    public PhieuNhapHang selectById(String idPhieu) {
        List<PhieuNhapHang> list = selectBySql("SELECT * FROM phieunhaphang WHERE idphieu = ?", idPhieu);
        return list.isEmpty() ? null : list.get(0);
    }
}
