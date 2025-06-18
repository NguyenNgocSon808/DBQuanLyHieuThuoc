package com.model.dao;

import com.model.entities.NhanVien;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements InterfaceDAO<NhanVien, String> {
    @Override
    public void create(NhanVien nv) {
        String sql = "INSERT INTO nhanvien (idnv, hoten, sdt, gioitinh, vaitro, namsinh, ngayvaolam) VALUES (?, ?, ?, ?, ?, ?, ?)";
        DatabaseConnection.update(sql, nv.getIdnv(), nv.getHoTen(), nv.getSdt(), nv.getGioiTinh(), nv.getVaiTro(), nv.getNamSinh(), new java.sql.Date(nv.getNgayVaoLam().getTime()));
    }

    @Override
    public void update(NhanVien nv) {
        String sql = "UPDATE nhanvien SET hoten=?, sdt=?, gioitinh=?, vaitro=?, namsinh=?, ngayvaolam=? WHERE idnv=?";
        DatabaseConnection.update(sql, nv.getHoTen(), nv.getSdt(), nv.getGioiTinh(), nv.getVaiTro(), nv.getNamSinh(), new java.sql.Date(nv.getNgayVaoLam().getTime()), nv.getIdnv());
    }

    @Override
    public void deleteById(String idnv) {
        String sql = "DELETE FROM nhanvien WHERE idnv=?";
        DatabaseConnection.update(sql, idnv);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new NhanVien(
                    rs.getString("idnv"),
                    rs.getString("hoten"),
                    rs.getString("sdt"),
                    rs.getString("gioitinh"),
                    rs.getString("vaitro"),
                    rs.getInt("namsinh"),
                    rs.getDate("ngayvaolam")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql("SELECT * FROM nhanvien");
    }

    @Override
    public NhanVien selectById(String idnv) {
        List<NhanVien> list = selectBySql("SELECT * FROM nhanvien WHERE idnv = ?", idnv);
        return list.isEmpty() ? null : list.get(0);
    }
}
