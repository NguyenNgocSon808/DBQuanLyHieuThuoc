package com.model.dao;

import com.model.entities.NhaCungCap;
import com.dbconnect.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO implements InterfaceDAO<NhaCungCap, String> {
    @Override
    public void create(NhaCungCap ncc) {
        String sql = "INSERT INTO nhacungcap (idncc, tennhacungcap, sdt, diachi) VALUES (?, ?, ?, ?)";
        DatabaseConnection.update(sql, ncc.getIdncc(), ncc.getTenNhaCungCap(), ncc.getSdt(), ncc.getDiaChi());
    }

    @Override
    public void update(NhaCungCap ncc) {
        String sql = "UPDATE nhacungcap SET tennhacungcap=?, sdt=?, diachi=? WHERE idncc=?";
        DatabaseConnection.update(sql, ncc.getTenNhaCungCap(), ncc.getSdt(), ncc.getDiaChi(), ncc.getIdncc());
    }

    @Override
    public void deleteById(String idncc) {
        String sql = "DELETE FROM nhacungcap WHERE idncc=?";
        DatabaseConnection.update(sql, idncc);
    }

    @Override
    public List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(sql, args);
            while (rs.next()) {
                list.add(new NhaCungCap(
                    rs.getString("idncc"),
                    rs.getString("tennhacungcap"),
                    rs.getString("sdt"),
                    rs.getString("diachi")
                ));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<NhaCungCap> selectAll() {
        return selectBySql("SELECT * FROM nhacungcap");
    }

    @Override
    public NhaCungCap selectById(String idncc) {
        List<NhaCungCap> list = selectBySql("SELECT * FROM nhacungcap WHERE idncc = ?", idncc);
        return list.isEmpty() ? null : list.get(0);
    }
}
