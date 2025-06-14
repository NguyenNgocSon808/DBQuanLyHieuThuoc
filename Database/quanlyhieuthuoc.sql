-- PostgreSQL schema based on the provided ERD image

CREATE TABLE khachhang (
    id VARCHAR(10) PRIMARY KEY,
    hoten VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    gioitinh VARCHAR(10) NOT NULL
);

CREATE TABLE nhanvien (
    idnv VARCHAR(10) PRIMARY KEY,
    hoten VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    gioitinh VARCHAR(10) NOT NULL,
    vaitro VARCHAR(50) NOT NULL CHECK (vaitro IN ('admin', 'nhanvien', 'quanly')),
    namsinh INT NOT NULL,
    ngayvaolam DATE NOT NULL
);

CREATE TABLE thuoc (
    id_thuoc VARCHAR(10) PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    thanhphan VARCHAR(255),
    donvitinh VARCHAR(20) NOT NULL CHECK (donvitinh IN ('Viên', 'Chai', 'Hộp', 'Gói', 'Vỉ')),
    danhmuc VARCHAR(20) NOT NULL,
    tennhacungcap VARCHAR(20) NOT NULL,
    idhd VARCHAR(10),
    gianhap FLOAT NOT NULL,
    giaban FLOAT NOT NULL,
    soluongton INTEGER NOT NULL,
    idphieu VARCHAR(10)
);

CREATE TABLE hoadon (
    idhd VARCHAR(10) PRIMARY KEY,
    tongtien FLOAT NOT NULL,
    thoigiantao TIMESTAMP NOT NULL,
    thoigiannhan TIMESTAMP,
    idnv VARCHAR(10) NOT NULL REFERENCES nhanvien(idnv),
    idkh VARCHAR(10) NOT NULL REFERENCES khachhang(id),
    idthuoc VARCHAR(10) NOT NULL REFERENCES thuoc(id_thuoc)
);

CREATE TABLE taikhoan (
    idtk VARCHAR(10) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    idnv VARCHAR(10) NOT NULL REFERENCES nhanvien(idnv),
    vaitro VARCHAR(50) NOT NULL CHECK (vaitro IN ('admin', 'nhanvien', 'quanly'))
);

CREATE TABLE nhacungcap (
    idncc VARCHAR(10) PRIMARY KEY,
    tennhacungcap VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    diachi VARCHAR(255) NOT NULL
);

CREATE TABLE phieunhaphang (
    idphieu VARCHAR(10) PRIMARY KEY,
    thoigian TIMESTAMP NOT NULL,
    idnv VARCHAR(10) NOT NULL REFERENCES nhanvien(idnv),
    idncc VARCHAR(10) NOT NULL REFERENCES nhacungcap(idncc),
    idthuoc VARCHAR(10) NOT NULL REFERENCES thuoc(id_thuoc),
    tennhaphang VARCHAR(255),
    tongtien FLOAT NOT NULL
);

ALTER TABLE thuoc
    ADD CONSTRAINT fk_thuoc_hoadon FOREIGN KEY (idhd) REFERENCES hoadon(idhd),
    ADD CONSTRAINT fk_thuoc_phieunhaphang FOREIGN KEY (idphieu) REFERENCES phieunhaphang(idphieu);
