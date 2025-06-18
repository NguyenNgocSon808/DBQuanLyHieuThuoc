-- Cập nhật tồn kho khi nhập hàng
CREATE OR REPLACE FUNCTION update_inventory_on_insert()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE thuoc
    SET soluongton = soluongton + NEW.soluong
    WHERE id_thuoc = NEW.idthuoc;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_inventory_on_insert
AFTER INSERT ON chitietphieunhap
FOR EACH ROW
EXECUTE FUNCTION update_inventory_on_insert();




-- Cập nhât tồn kho sau khi bán hàng
CREATE OR REPLACE FUNCTION update_inventory_on_sale()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE thuoc
    SET soluongton = soluongton - NEW.soluong
    WHERE id_thuoc = NEW.idthuoc;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_inventory_on_sale
AFTER INSERT ON chitiethoadon
FOR EACH ROW
EXECUTE FUNCTION update_inventory_on_sale();





-- Kiểm tra tồn kho trước khi bán
CREATE OR REPLACE FUNCTION check_inventory_before_sale()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT soluongton FROM thuoc WHERE id_thuoc = NEW.idthuoc) < NEW.soluong THEN
        RAISE EXCEPTION 'Không đủ hàng trong kho!';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_check_inventory_before_sale
BEFORE INSERT ON chitiethoadon
FOR EACH ROW
EXECUTE FUNCTION check_inventory_before_sale();





-- Tự động tính tổng tiền hóa đơn
CREATE OR REPLACE FUNCTION update_invoice_total()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE hoadon
    SET tongtien = tongtien + (NEW.soluong * NEW.dongia)
    WHERE idhd = NEW.idhd;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_invoice_total
AFTER INSERT ON chitiethoadon
FOR EACH ROW
EXECUTE FUNCTION update_invoice_total();





-- Tự động tính tổng tiền phiếu nhập 
CREATE OR REPLACE FUNCTION update_receipt_total()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE phieunhaphang
    SET tongtien = tongtien + (NEW.soluong * NEW.gianhap)
    WHERE idphieu = NEW.idphieu;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_receipt_total
AFTER INSERT ON chitietphieunhap
FOR EACH ROW
EXECUTE FUNCTION update_receipt_total();



-- Tự động thêm nhân viên khi tạo tài khoản
CREATE OR REPLACE FUNCTION insert_nhanvien_when_create_account()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO nhanvien (idnv, hoten, sdt, gioitinh, vaitro, namsinh, ngayvaolam)
    VALUES (
        NEW.idnv,
        null,      -- hoten (default/placeholder)
        NULL,      -- sdt (default/placeholder)
        NULL,      -- gioitinh (default/placeholder)
        NEW.vaitro,
        2000,                 -- namsinh (default/placeholder)
        CURRENT_DATE
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_insert_nhanvien_when_create_account
AFTER INSERT ON taikhoan
FOR EACH ROW
EXECUTE FUNCTION insert_nhanvien_when_create_account();


