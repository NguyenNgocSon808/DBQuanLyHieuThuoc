package com.model.dao;

import com.model.entities.TaiKhoan;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO implements InterfaceDAO<TaiKhoan, String> {
    @Override
    public void create(TaiKhoan tk) {
        String sql = "INSERT INTO taikhoan (idtk, username, password, idnv, vaitro) VALUES (?, ?, ?, ?, ?)";
        DatabaseConnection.update(sql, tk.getIdtk(), tk.getUsername(), tk.getPassword(), tk.getIdnv(), tk.getVaiTro());
    }

    @Override
    public void update(TaiKhoan tk) {
        String sql = "UPDATE taikhoan SET username=?, password=?, idnv=?, vaitro=? WHERE idtk=?";
        DatabaseConnection.update(sql, tk.getUsername(), tk.getPassword(), tk.getIdnv(), tk.getVaiTro(), tk.getIdtk());
    }

    @Override
    public void deleteById(String idtk) {
        String sql = "DELETE FROM taikhoan WHERE idtk=?";
        DatabaseConnection.update(sql, idtk);
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new TaiKhoan(
                    rs.getString("idtk"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("idnv"),
                    rs.getString("vaitro")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql("SELECT * FROM taikhoan");
    }

    @Override
    public TaiKhoan selectById(String idtk) {
        List<TaiKhoan> list = selectBySql("SELECT * FROM taikhoan WHERE idtk = ?", idtk);
        return list.isEmpty() ? null : list.get(0);
    }
}
