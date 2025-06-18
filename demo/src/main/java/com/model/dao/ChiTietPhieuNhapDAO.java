package com.model.dao;

import com.model.entities.ChiTietPhieuNhap;
import java.util.List;

public interface ChiTietPhieuNhapDAO {
    void create(ChiTietPhieuNhap ctpn);
    void update(ChiTietPhieuNhap ctpn);
    void deleteById(String idPhieu, String idThuoc);
    List<ChiTietPhieuNhap> selectAll();
    ChiTietPhieuNhap selectById(String idPhieu, String idThuoc);
}
