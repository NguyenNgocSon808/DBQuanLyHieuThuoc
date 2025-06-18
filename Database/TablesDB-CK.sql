-- Bảng Tài Khoản
CREATE TABLE taikhoan (
    idtk VARCHAR(10) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    idnv VARCHAR(10) NOT NULL,
    vaitro VARCHAR(50) NOT NULL CHECK (LOWER(vaitro) IN (LOWER('Admin'), LOWER('Nhân viên'), LOWER('Quản lý')))
);

-- Bảng Khách Hàng
CREATE TABLE khachhang (
    id VARCHAR(10) PRIMARY KEY,
    hoten VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    gioitinh VARCHAR(10) NOT NULL,
    idtk VARCHAR(10) NOT NULL REFERENCES taikhoan(idtk)
);

-- Bảng Nhân Viên
CREATE TABLE nhanvien (
    idnv VARCHAR(10) PRIMARY KEY,
    hoten VARCHAR(255),
    sdt VARCHAR(20),
    gioitinh VARCHAR(10),
    vaitro VARCHAR(50) NOT NULL CHECK (vaitro IN ('Admin', 'Nhân viên', 'Quản lý')),
    namsinh INT,
    ngayvaolam DATE NOT NULL
);

-- Bảng Thuốc
CREATE TABLE thuoc (
    id_thuoc VARCHAR(10) PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    thanhphan VARCHAR(255),
    donvitinh VARCHAR(20) NOT NULL CHECK (donvitinh IN ('Viên', 'Chai', 'Hộp', 'Gói', 'Vỉ')),
    danhmuc VARCHAR(50) NOT NULL,
    xuatxu VARCHAR(20) NOT NULL,
    gianhap FLOAT NOT NULL,
    giaban FLOAT NOT NULL,
    soluongton INTEGER NOT NULL
);

-- Bảng Nhà Cung Cấp
CREATE TABLE nhacungcap (
    idncc VARCHAR(10) PRIMARY KEY,
    tennhacungcap VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    diachi VARCHAR(255) NOT NULL
);

-- Bảng Phiếu Nhập Hàng (Chỉ lưu thông tin chung)
CREATE TABLE phieunhaphang (
    idphieu VARCHAR(10) PRIMARY KEY,
    thoigian TIMESTAMP NOT NULL,
    idnv VARCHAR(10) NOT NULL REFERENCES nhanvien(idnv),
    idncc VARCHAR(10) NOT NULL REFERENCES nhacungcap(idncc),
    tennhaphang VARCHAR(255),
    tongtien FLOAT NOT NULL
);

-- Bảng Chi Tiết Phiếu Nhập (nhiều thuốc trong 1 phiếu)
CREATE TABLE chitietphieunhap (
    idphieu VARCHAR(10) NOT NULL REFERENCES phieunhaphang(idphieu),
    idthuoc VARCHAR(10) NOT NULL REFERENCES thuoc(id_thuoc),
    soluong INTEGER NOT NULL,
    gianhap FLOAT NOT NULL,
    PRIMARY KEY (idphieu, idthuoc)
);

-- Bảng Hóa Đơn
CREATE TABLE hoadon (
    idhd VARCHAR(10) PRIMARY KEY,
    tongtien FLOAT NOT NULL,
    thoigiantao TIMESTAMP NOT NULL,
    thoigiannhan TIMESTAMP,
    idnv VARCHAR(10) NOT NULL REFERENCES nhanvien(idnv),
    idkh VARCHAR(10) NOT NULL REFERENCES khachhang(id)
);

-- Bảng Chi Tiết Hóa Đơn
CREATE TABLE chitiethoadon (
    idhd VARCHAR(10) NOT NULL REFERENCES hoadon(idhd),
    idthuoc VARCHAR(10) NOT NULL REFERENCES thuoc(id_thuoc),
    soluong INTEGER NOT NULL,
    dongia FLOAT NOT NULL,
    PRIMARY KEY (idhd, idthuoc)
);


