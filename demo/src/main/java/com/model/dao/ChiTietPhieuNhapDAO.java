package com.model.dao;

import com.model.entities.ChiTietPhieuNhap;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAO implements InterfaceDAO<ChiTietPhieuNhap, String[]> {
    @Override
    public void create(ChiTietPhieuNhap ctpn) {
        String sql = "INSERT INTO chitietphieunhap (idphieu, idthuoc, soluong, gianhap) VALUES (?, ?, ?, ?)";
        DatabaseConnection.update(sql, ctpn.getIdPhieu(), ctpn.getIdThuoc(), ctpn.getSoLuong(), ctpn.getGiaNhap());
    }

    @Override
    public void update(ChiTietPhieuNhap ctpn) {
        String sql = "UPDATE chitietphieunhap SET soluong=?, gianhap=? WHERE idphieu=? AND idthuoc=?";
        DatabaseConnection.update(sql, ctpn.getSoLuong(), ctpn.getGiaNhap(), ctpn.getIdPhieu(), ctpn.getIdThuoc());
    }

    @Override
    public void deleteById(String[] key) {
        String sql = "DELETE FROM chitietphieunhap WHERE idphieu=? AND idthuoc=?";
        DatabaseConnection.update(sql, key[0], key[1]);
    }

    @Override
    public List<ChiTietPhieuNhap> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new ChiTietPhieuNhap(
                    rs.getString("idphieu"),
                    rs.getString("idthuoc"),
                    rs.getInt("soluong"),
                    rs.getDouble("gianhap")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<ChiTietPhieuNhap> selectAll() {
        return selectBySql("SELECT * FROM chitietphieunhap");
    }

    @Override
    public ChiTietPhieuNhap selectById(String[] key) {
        List<ChiTietPhieuNhap> list = selectBySql("SELECT * FROM chitietphieunhap WHERE idphieu = ? AND idthuoc = ?", key[0], key[1]);
        return list.isEmpty() ? null : list.get(0);
    }
}
