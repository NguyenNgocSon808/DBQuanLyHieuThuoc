package com.model.dao;

import com.model.entities.TaiKhoan;
import java.util.List;

public interface TaiKhoanDAO {
    void insert(TaiKhoan taiKhoan);
    void update(TaiKhoan taiKhoan);
    void delete(String idtk);
    TaiKhoan getById(String idtk);
    List<TaiKhoan> getAll();
}
