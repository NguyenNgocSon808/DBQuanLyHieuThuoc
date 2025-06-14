package com.model.dao;

import com.model.entities.NhaCungCap;
import java.util.List;

public interface NhaCungCapDAO {
    void insert(NhaCungCap ncc);
    void update(NhaCungCap ncc);
    void delete(String idncc);
    NhaCungCap getById(String idncc);
    List<NhaCungCap> getAll();
}
