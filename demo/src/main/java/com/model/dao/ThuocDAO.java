package com.model.dao;

import com.model.entities.Thuoc;
import java.util.List;

public interface ThuocDAO {
    void insert(Thuoc thuoc);
    void update(Thuoc thuoc);
    void delete(String idThuoc);
    Thuoc getById(String idThuoc);
    List<Thuoc> getAll();
}
