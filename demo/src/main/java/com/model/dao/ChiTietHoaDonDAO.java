package com.model.dao;

import com.model.entities.ChiTietHoaDon;
import java.util.List;

public interface ChiTietHoaDonDAO {
    void create(ChiTietHoaDon cthd);
    void update(ChiTietHoaDon cthd);
    void deleteById(String idhd, String idThuoc);
    List<ChiTietHoaDon> selectAll();
    ChiTietHoaDon selectById(String idhd, String idThuoc);
}
