package com.model.dao;

import com.model.entities.PhieuNhapHang;
import java.util.List;

public interface PhieuNhapHangDAO {
    void insert(PhieuNhapHang phieuNhapHang);
    void update(PhieuNhapHang phieuNhapHang);
    void delete(String idPhieu);
    PhieuNhapHang getById(String idPhieu);
    List<PhieuNhapHang> getAll();
}
