package com.model.dao;

import com.model.entities.ChiTietHoaDon;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO implements InterfaceDAO<ChiTietHoaDon, String[]> {
    @Override
    public void create(ChiTietHoaDon cthd) {
        String sql = "INSERT INTO chitiethoadon (idhd, idthuoc, soluong, dongia) VALUES (?, ?, ?, ?)";
        DatabaseConnection.update(sql, cthd.getIdhd(), cthd.getIdThuoc(), cthd.getSoLuong(), cthd.getDonGia());
    }

    @Override
    public void update(ChiTietHoaDon cthd) {
        String sql = "UPDATE chitiethoadon SET soluong=?, dongia=? WHERE idhd=? AND idthuoc=?";
        DatabaseConnection.update(sql, cthd.getSoLuong(), cthd.getDonGia(), cthd.getIdhd(), cthd.getIdThuoc());
    }

    @Override
    public void deleteById(String[] key) {
        String sql = "DELETE FROM chitiethoadon WHERE idhd=? AND idthuoc=?";
        DatabaseConnection.update(sql, key[0], key[1]);
    }

    @Override
    public List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new ChiTietHoaDon(
                    rs.getString("idhd"),
                    rs.getString("idthuoc"),
                    rs.getInt("soluong"),
                    rs.getDouble("dongia")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        return selectBySql("SELECT * FROM chitiethoadon");
    }

    @Override
    public ChiTietHoaDon selectById(String[] key) {
        List<ChiTietHoaDon> list = selectBySql("SELECT * FROM chitiethoadon WHERE idhd = ? AND idthuoc = ?", key[0], key[1]);
        return list.isEmpty() ? null : list.get(0);
    }
}
