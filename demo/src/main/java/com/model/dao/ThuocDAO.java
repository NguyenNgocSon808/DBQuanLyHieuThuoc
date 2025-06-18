package com.model.dao;

import com.model.entities.Thuoc;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAO implements InterfaceDAO<Thuoc, String> {
    @Override
    public void create(Thuoc thuoc) {
        String sql = "INSERT INTO thuoc (id_thuoc, ten, thanhphan, donvitinh, danhmuc, xuatxu, gianhap, giaban, soluongton) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseConnection.update(sql,
            thuoc.getIdThuoc(),
            thuoc.getTen(),
            thuoc.getThanhPhan(),
            thuoc.getDonViTinh(),
            thuoc.getDanhMuc(),
            thuoc.getXuatXu(),
            thuoc.getGiaNhap(),
            thuoc.getGiaBan(),
            thuoc.getSoLuongTon()
        );
    }

    @Override
    public void update(Thuoc thuoc) {
        String sql = "UPDATE thuoc SET ten=?, thanhphan=?, donvitinh=?, danhmuc=?, xuatxu=?, gianhap=?, giaban=?, soluongton=? WHERE id_thuoc=?";
        DatabaseConnection.update(sql,
            thuoc.getTen(),
            thuoc.getThanhPhan(),
            thuoc.getDonViTinh(),
            thuoc.getDanhMuc(),
            thuoc.getXuatXu(),
            thuoc.getGiaNhap(),
            thuoc.getGiaBan(),
            thuoc.getSoLuongTon(),
            thuoc.getIdThuoc()
        );
    }

    @Override
    public void deleteById(String idThuoc) {
        String sql = "DELETE FROM thuoc WHERE id_thuoc=?";
        DatabaseConnection.update(sql, idThuoc);
    }

    @Override
    public List<Thuoc> selectBySql(String sql, Object... args) {
        List<Thuoc> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new Thuoc(
                    rs.getString("id_thuoc"),
                    rs.getString("ten"),
                    rs.getString("thanhphan"),
                    rs.getString("donvitinh"),
                    rs.getString("danhmuc"),
                    rs.getString("xuatxu"),
                    rs.getDouble("gianhap"),
                    rs.getDouble("giaban"),
                    rs.getInt("soluongton")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Thuoc> selectAll() {
        return selectBySql("SELECT * FROM thuoc");
    }

    @Override
    public Thuoc selectById(String idThuoc) {
        List<Thuoc> list = selectBySql("SELECT * FROM thuoc WHERE id_thuoc = ?", idThuoc);
        return list.isEmpty() ? null : list.get(0);
    }
}
