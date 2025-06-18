INSERT INTO nhanvien (idnv, hoten, sdt, gioitinh, vaitro, namsinh, ngayvaolam) VALUES
    ('AVHGD2GD6', 'Nguyễn Ngọc Sơn', '0356 093 860', 'Nam', 'Quản lý', 2005, '2024-04-18'),
    ('LKD2SFSL1', 'Nguyễn Anh Tuấn', '0380 312 077', 'Nam', 'Quản lý', 2005, '2024-03-22'),
    ('IU42JDKJ2', 'Đàm Đức Huy', '0844 916 211', 'Nam', 'Quản lý', 2005, '2024-02-16'),
    ('DKJFJO1K2', 'Nguyễn Minh Tiệp', '0373 279 368', 'Nam', 'Quản lý', 2005, '2024-10-04');

	
INSERT INTO khachhang (id, hoten, sdt, gioitinh) VALUES
    ('ASDASN131', N'Nguyễn Văn Hùng', '0906765871', N'Nam'),
	('12ZAS1SX1', N'Nguyễn Thị Lan', '0931265687', N'Nữ'),
	('SDF3F13DZ', N'Lê Đức Anh', '0967566712', N'Nam'),
	('ABCD12345', N'Trần Mai Hương', '0987654321', N'Nữ'),
	('XYZ98765Z', N'Phạm Xuân Phong', '0912345678', N'Nam'),
	('KLM45678X', N'Lê Thị Linh', '0956789012', N'Nữ'),
	('PQR23456V', N'Hồ Ngọc Minh', '0923456789', N'Nam'),
	('789ABCDEF', N'Võ Thị Hải Yến', '0945678901', N'Nữ'),
	('456ZYXWVQ', N'Phạm Thị Anh', '0978901234', N'Nữ'),
	('QWE78901S', N'Hoàng Hữu Đức', '0912345678', N'Nam');

INSERT INTO thuoc (id_thuoc, ten, thanhphan, donvitinh, danhmuc, xuatxu, gianhap, giaban, soluongton) VALUES

	('X12IFO4BZ', 'Hapacol 650 DHG', 'Paracetamol', N'Hộp', N'Thuốc giảm đau', N'Việt Nam', 20000, 25000, 1021),
	('XRZXFO4BZ', N'Bột pha hỗn dịch uống Smecta vị cam', N'Diosmectite', N'Gói', N'Hệ tiêu hóa và gan mật', N'Campuchia', 3000, 4000, 1021),
	('XRBIFO4BZ', N'Siro C.C Life 100mg/5ml Foripharm', N'Vitamin C', N'Chai', N'Hệ tiêu hóa và gan mật', N'Việt Nam', 25000, 30000, 1032),
	('VFZCHLHIE', N'Panadol Extra đỏ', N'Caffeine, Paracetamol', N'Hộp', N'Thuốc giảm đau', N'Mỹ', 235000, 250000, 1034),
	('MJ9AB7J1I', N'Viên sủi Vitatrum C BRV', N'Sỏi thận, Rối loạn chuyển hoá fructose, Bệnh Thalassemia, Tăng oxalat niệu, Rối loạn chuyển hoá oxalat', N'Hộp', N'Hệ tiêu hóa và gan mật', N'Mỹ', 20000, 24000, 1076),
	('ESMJMM7T1', N'Bổ Gan Trường Phúc', N'Diệp hạ châu, Đảng Sâm, Bạch truật, Cam thảo, Phục Linh, Nhân trần, Trần bì', N'Hộp', N'Hệ tiêu hóa và gan mật', N'Việt Nam', 85000, 95000, 1034),
	('BV07519DS', N'Bài Thạch Trường Phúc', N'Xa tiền tử, Bạch mao căn, Sinh Địa, Ý Dĩ, Kim tiền thảo', N'Hộp', N'Hệ tiêu hóa và gan mật', N'Việt Nam', 85000, 95000, 1076),
	('798E63U16', N'Đại Tràng Trường Phúc', N'Hoàng liên, Mộc hương, Bạch truật, Bạch thược, Ngũ bội tử, Hậu phác, Cam thảo, Xa tiền tử, Hoạt thạch', N'Hộp', N'Hệ tiêu hóa và gan mật', N'Việt Nam', 90000, 105000, 1021),
	('745KCI1KX', N'Ninh Tâm Vương Hồng Bàng', N'L-Carnitine, Taurine, Đan sâm, Khổ sâm bắc, Nattokinase, Hoàng đằng, Magie, Tá dược vừa đủ', N'Hộp', N'Hệ tim mạch và tạo máu', N'Nhật Bản', 165000, 180000, 1054);

INSERT INTO NhaCungCap (idncc, tennhacungcap, sdt, diaChi) VALUES
  ('XCZXWE123', N'Công ty Cổ phần Dược phẩm An Khang', '0283820618', N'282-284 Trần Hưng Đạo, Phường Nguyễn Cư Trinh, Quận 1, TP.HCM'),
  ('23HUSZ173', N'Công ty Cổ phần Dược phẩm Pharmacity', '0243825353', N'426 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, TP.HCM'),
  ('ZXHUWE12S', N'Hệ thống nhà thuốc ECO', '0283689339', N'336 Phan Văn Trị, Phường 11, Quận Bình Thạnh, TP.HCM'),
  ('N4M35KL1B', N'Công ty Dược phẩm Phano', '0243574133', N'286 P. Xã Đàn, Đống Đa, Hà Nội'),
  ('XCHUWE123', N'Công ty Dược phẩm Trung ương 2', '0243825535', '138B Đội Cấn, Ba Đình, Hà Nội'),
  ('2B32N31B2', N'Công ty Dược phẩm VCP', '0285413833', N'780 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. Hồ Chí Minh');

INSERT INTO hoadon (idhd, tongtien, thoigiantao, thoigiannhan, idnv, idkh) VALUES
    ('V1DFWISZ0', 105000, '2024-04-01 14:21:13', NULL, 'DKJFJO1K2', 'ABCD12345'),
    ('MNS6VLQ9F', 180000, '2024-04-02 16:12:51', NULL, 'AVHGD2GD6', 'XYZ98765Z'),
    ('3P06S5KGG', 90000, '2024-04-03 08:31:31', NULL, 'LKD2SFSL1', 'KLM45678X'),
    ('R4DDC67Q0', 270000, '2024-04-04 10:12:41', NULL, 'IU42JDKJ2', 'PQR23456V'),
    ('SKUQJUB5Z', 30000, '2024-04-05 12:31:36', NULL, 'DKJFJO1K2', '789ABCDEF'),
    ('F8BARB18Z', 105000, '2024-03-09 14:12:11', NULL, 'AVHGD2GD6', '456ZYXWVQ'),
    ('8XBLQZV9B', 345000, '2024-03-10 16:03:43', NULL, 'LKD2SFSL1', 'QWE78901S'),
    ('914KKABW3', 95000, '2024-03-11 08:07:32', NULL, 'IU42JDKJ2', 'ASDASN131'),
    ('TJ6QM5STW', 400000, '2024-03-12 10:45:11', NULL, 'DKJFJO1K2', '12ZAS1SX1'),
    ('B42SJZNIM', 30000, '2024-03-13 12:54:22', NULL, 'AVHGD2GD6', 'SDF3F13DZ'),
    ('41C5TNFGE', 280000, '2024-02-14 14:14:30', NULL, 'LKD2SFSL1', 'ABCD12345'),
    ('ME9CL5ER6', 280000, '2024-02-15 16:15:13', NULL, 'IU42JDKJ2', 'XYZ98765Z'),
    ('WXOX8PE0Q', 500000, '2024-02-16 08:56:11', NULL, 'DKJFJO1K2', 'KLM45678X'),
    ('63V7R8RBE', 250000, '2024-02-17 10:18:53', NULL, 'AVHGD2GD6', 'PQR23456V'),
    ('1B78SGIZV', 105000, '2024-02-18 12:28:06', NULL, 'LKD2SFSL1', '789ABCDEF'),
    ('VBA5E001G', 200000, '2024-02-19 14:38:28', NULL, 'IU42JDKJ2', '456ZYXWVQ'),
    ('HAT7YG1MK', 240000, '2024-02-20 16:16:29', NULL, 'DKJFJO1K2', 'QWE78901S'),
    ('ASZS32JZX', 135000, '2024-02-21 16:16:29', NULL, 'DKJFJO1K2', '12ZAS1SX1'),
    ('MNXS72JXA', 465000, '2024-02-22 16:16:29', NULL, 'IU42JDKJ2', 'ASDASN131');

INSERT INTO ChiTietHoaDon(idhd, idthuoc, soluong, dongia) VALUES
	('V1DFWISZ0', '798E63U16', 1, 105000),
	('MNS6VLQ9F', '745KCI1KX', 1, 180000),
	('3P06S5KGG', 'XRBIFO4BZ', 3, 30000),
	('R4DDC67Q0', 'XRZXFO4BZ', 5, 4000),
	('R4DDC67Q0', 'VFZCHLHIE', 1, 250000),
	('SKUQJUB5Z', 'XRBIFO4BZ', 1, 30000),
	('F8BARB18Z', '798E63U16', 1, 105000),
	('8XBLQZV9B', 'ESMJMM7T1', 1, 95000),
	('8XBLQZV9B', 'VFZCHLHIE', 1, 250000),
	('914KKABW3', 'ESMJMM7T1', 1, 95000),
	('TJ6QM5STW', 'XRBIFO4BZ', 1, 30000),
	('TJ6QM5STW', 'VFZCHLHIE', 1, 250000),
	('TJ6QM5STW', 'X12IFO4BZ', 1, 120000),
	('B42SJZNIM', 'XRBIFO4BZ', 1, 30000),
	('41C5TNFGE', 'XRBIFO4BZ', 1, 30000),
	('41C5TNFGE', 'VFZCHLHIE', 1, 250000),
	('ME9CL5ER6', 'XRBIFO4BZ', 1, 30000),
	('ME9CL5ER6', 'VFZCHLHIE', 1, 250000),
	('WXOX8PE0Q', 'VFZCHLHIE', 2, 250000),
	('63V7R8RBE', 'VFZCHLHIE', 1, 250000),
	('1B78SGIZV', '798E63U16', 1, 105000),
	('VBA5E001G', '798E63U16', 1, 105000),
	('VBA5E001G', 'ESMJMM7T1', 1, 95000),
	('HAT7YG1MK', 'X12IFO4BZ', 2, 120000),
	('ASZS32JZX', 'X12IFO4BZ', 3, 25000),
	('ASZS32JZX', 'XRZXFO4BZ', 2, 30000),
	('MNXS72JXA', 'ESMJMM7T1', 2, 95000),
	('MNXS72JXA', 'VFZCHLHIE', 1, 250000),
	('MNXS72JXA', 'X12IFO4BZ', 1, 25000);

INSERT INTO phieunhaphang (idphieu, thoigian, idnv, idncc, tennhaphang, tongtien) VALUES
    ('PPJ9DNBL7', '2024-03-04 13:12:42', 'DKJFJO1K2', 'XCZXWE123', N'Phiếu nhập hàng ngày 04-03-2024', 10500000),
    ('RXPXRWR36', '2024-03-05 11:31:26', 'AVHGD2GD6', '23HUSZ173', N'Phiếu nhập hàng ngày 05-03-2024', 19800000),
    ('ZQKV59121', '2024-03-06 07:18:32', 'LKD2SFSL1', 'ZXHUWE12S', N'Phiếu nhập hàng ngày 06-03-2024', 6000000),
    ('C45PX5VYN', '2024-03-07 10:26:21', 'IU42JDKJ2', 'XCHUWE123', N'Phiếu nhập hàng ngày 07-03-2024', 77000000),
    ('A4B3VKX8V', '2024-03-11 08:35:37', 'IU42JDKJ2', 'XCHUWE123', N'Phiếu nhập hàng ngày 11-03-2024', 9500000);

INSERT INTO ChiTietPhieuNhap(idphieu, idthuoc, soluong, gianhap) VALUES
	('PPJ9DNBL7', '798E63U16', 100, 105000),
	('RXPXRWR36', '745KCI1KX', 110, 180000),
	('ZQKV59121', 'XRBIFO4BZ', 200, 30000),
	('C45PX5VYN', 'XRZXFO4BZ', 500, 4000),
	('C45PX5VYN', 'VFZCHLHIE', 300, 250000),
	('A4B3VKX8V', 'ESMJMM7T1', 100, 95000);
INSERT INTO taikhoan (idtk, username, password, idnv, vaitro) VALUES 
    ('TK001', 'ngocson', '18042005', 'AVHGD2GD6', 'Quản lý'),
    ('TK002', 'minhtiep', '04102005', 'DKJFJO1K2', 'Quản lý'),
    ('TK003', 'duchuy',   '16022005', 'IU42JDKJ2', 'Quản lý'),
    ('TK004', 'anhtuan',  '22032005', 'LKD2SFSL1', 'Quản lý');

