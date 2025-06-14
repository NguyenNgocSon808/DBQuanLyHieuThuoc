package com.model.dao;

import com.model.entities.NhanVien;
import java.util.List;

public interface NhanVienDAO {
    void insert(NhanVien nhanVien);
    void update(NhanVien nhanVien);
    void delete(String idnv);
    NhanVien getById(String idnv);
    List<NhanVien> getAll();
}
