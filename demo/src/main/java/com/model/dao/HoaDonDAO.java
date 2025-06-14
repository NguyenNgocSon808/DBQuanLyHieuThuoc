package com.model.dao;

import com.model.entities.HoaDon;
import java.util.List;

public interface HoaDonDAO {
    void insert(HoaDon hoaDon);
    void update(HoaDon hoaDon);
    void delete(String idhd);
    HoaDon getById(String idhd);
    List<HoaDon> getAll();
}
