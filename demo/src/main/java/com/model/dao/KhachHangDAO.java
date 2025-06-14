package com.model.dao;

import com.model.entities.KhachHang;
import java.util.List;

public interface KhachHangDAO {
    void insert(KhachHang khachHang);
    void update(KhachHang khachHang);
    void delete(String id);
    KhachHang getById(String id);
    List<KhachHang> getAll();
}
