package com.model.dao;

import com.model.entities.KhachHang;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO implements InterfaceDAO<KhachHang, String> {
    @Override
    public void create(KhachHang kh) {
        String sql = "INSERT INTO khachhang (id, hoten, sdt, gioitinh) VALUES (?, ?, ?, ?)";
        DatabaseConnection.update(sql, kh.getId(), kh.getHoTen(), kh.getSdt(), kh.getGioiTinh());
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "UPDATE khachhang SET hoten=?, sdt=?, gioitinh=? WHERE id=?";
        DatabaseConnection.update(sql, kh.getHoTen(), kh.getSdt(), kh.getGioiTinh(), kh.getId());
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM khachhang WHERE id=?";
        DatabaseConnection.update(sql, id);
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new KhachHang(
                    rs.getString("id"),
                    rs.getString("hoten"),
                    rs.getString("sdt"),
                    rs.getString("gioitinh")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql("SELECT * FROM khachhang");
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = selectBySql("SELECT * FROM khachhang WHERE id = ?", id);
        return list.isEmpty() ? null : list.get(0);
    }
}
