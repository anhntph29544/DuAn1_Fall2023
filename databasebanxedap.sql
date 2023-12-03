	create database sport_bicycle1
	go
	use sport_bicycle1
	go
	create table kieu_dang_xe(
		id_kieu_dang_xe uniqueidentifier primary key,
		ma varchar(10),
		ten nvarchar(50),
		trang_thai int
	)
	create table kich_thuoc(
		id_kich_thuoc uniqueidentifier primary key,
		ma varchar(10),
		ten nvarchar(50),
		trang_thai int
	)
	create table mau_sac(
		id_mau_sac uniqueidentifier primary key,
		ma varchar(10),
		ten nvarchar(50),
		trang_thai int
	)
	create table san_pham(
		id_san_pham uniqueidentifier primary key,
		ma varchar(10),
		ten nvarchar(50),
		trang_thai int
	)
	create table thuong_hieu(
		id_thuong_hieu uniqueidentifier primary key,
		ma varchar(10),
		ten nvarchar(50),
		trang_thai int
	)
	create table san_pham_chi_tiet(
		id_spct uniqueidentifier primary key,
		id_kieu_dang_xe uniqueidentifier,
		foreign key (id_kieu_dang_xe) references kieu_dang_xe(id_kieu_dang_xe),
		id_kich_thuoc uniqueidentifier,
		foreign key (id_kich_thuoc) references kich_thuoc(id_kich_thuoc),
		hinh_anh varchar(max),
	id_mau_sac uniqueidentifier,
	foreign key (id_mau_sac) references mau_sac(id_mau_sac),
	id_thuong_hieu uniqueidentifier,
	foreign key (id_thuong_hieu) references thuong_hieu(id_thuong_hieu),
	id_san_pham uniqueidentifier,
	foreign key (id_san_pham) references san_pham(id_san_pham),
	ma varchar(20),
	mo_ta nvarchar(100),
	so_luong_ton int,
	gia decimal(20),
	trang_thai int
)
create table chuc_vu(
	id_chuc_vu uniqueidentifier primary key,
	ma varchar(20),
	ten nvarchar(50),
	trang_thai int
)
create table nhan_vien(
	id_nhan_vien uniqueidentifier primary key,
	id_chuc_vu uniqueidentifier,
	foreign key(id_chuc_vu) references chuc_vu(id_chuc_vu),
	ma varchar(20),
	email varchar(50),
	ho_ten nvarchar(50),
	image varchar(255),
	cccd varchar(40),
	gioi_tinh nvarchar(20),
	ngay_sinh date,
	thanh_pho nvarchar(50),
	huyen nvarchar(50),
	xa nvarchar(50),
	so_nha nvarchar(50),
	sdt varchar(20),
	mat_khau varchar(20),
	trang_thai int
)
create table khach_hang(
	id_kh uniqueidentifier primary key,
	ma varchar(20),
	ten nvarchar(50),
	image varchar(50),
	ngay_sinh date,
	email varchar(50),
	sdt varchar(20),
		cccd varchar(20),
	mat_khau varchar(20),
	gioi_tinh int,
	thanh_pho nvarchar(50),
	huyen nvarchar(50),
	xa nvarchar(50),
	so_nha nvarchar(50),
	trang_thai int
)
select*from khach_hang
select*from nhan_vien
create table voucher(
	id_voucher uniqueidentifier primary key,
	so_luong int,
	gia_tri decimal,
	ngay_bat_dau Date,
	ngay_ket_thuc Date,
	trang_thai int
)
create table hoa_don(
	id_hoa_don uniqueidentifier primary key,
	id_kh uniqueidentifier,
	foreign key(id_kh) references khach_hang(id_kh),
	id_voucher uniqueidentifier,
	foreign key(id_voucher) references voucher(id_voucher),
		id_nhan_vien uniqueidentifier,
	foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
	ma varchar(20),
	loai_hoa_don int,
	ngay_thanh_toan datetime,
	tinh_trang int,
	tien_khach_dua decimal(30),
        thanh_tien decimal(30),
	tien_thua decimal(30),
	ngay_them datetime,
)
create table hoa_don_chi_tiet(
	id_hoa_don_chi_tiet uniqueidentifier primary key,
	id_spct uniqueidentifier,
	foreign key(id_spct) references san_pham_chi_tiet(id_spct),
	id_hoa_don uniqueidentifier,
	foreign key(id_hoa_don) references hoa_don(id_hoa_don),
	gia decimal(20),
	so_luong int,
	trang_thai int
)
select*from nhan_vien
alter table san_pham add ngay_them datetime
alter table kieu_dang_xe add ngay_them datetime
alter table kich_thuoc add ngay_them datetime
alter table thuong_hieu add ngay_them datetime
alter table mau_sac add ngay_them datetime
alter table khach_hang add cccd varchar(20)
alter table voucher add ma nvarchar(50)
alter table hoa_don add tong_tien decimal(30),
INSERT INTO chuc_vu (id_chuc_vu, ma, ten, trang_thai)
VALUES
    ('3f3d5487-60c0-4eb8-9004-2023e69cff26', 'CV001', N'Quản lý', 1),
	('a0b5ab61-0634-436a-b471-f53b29cbdffe', 'CV002', N'Nhân viên', 1)

	-- Dữ liệu cho bảng nhan_vien
INSERT INTO nhan_vien (id_nhan_vien, id_chuc_vu, ma, email, ho_ten, image, cccd, gioi_tinh, ngay_sinh, thanh_pho, huyen, xa, so_nha, sdt, mat_khau, trang_thai)
VALUES
	('bfd3985e-aadc-4694-b89b-18151abc17d9', '3f3d5487-60c0-4eb8-9004-2023e69cff26', 'NV001', 'nhanvien1@example.com', N'Nguyễn Văn A', 'null', '123456789', 0, '1990-01-01', N'Hà Nội', N'Ba Đình', N'Cống Vị', N'123 Đường ABC', '0987654321', 'password1', 1),
	('bed21cd4-6442-4f54-908c-c77695812b74', 'a0b5ab61-0634-436a-b471-f53b29cbdffe', 'NV002', 'nhanvien2@example.com', N'Trần Thị B', 'null', '987654321', 1, '1995-05-05', N'Hồ Chí Minh', N'Quận 1', N'Bến Nghé', N'456 Đường XYZ', '0123456789', 'password2', 1)

	-- Dữ liệu cho bảng khach_hang
INSERT INTO khach_hang (id_kh, ma, ten, image, ngay_sinh, email, sdt, mat_khau, gioi_tinh, thanh_pho, huyen, xa, so_nha, trang_thai)
VALUES
	('8579ae3f-8b87-4f2e-b3fa-8c0f4a9733f0', 'KH001', N'Nguyễn Thị D', 'null', '1988-08-08', 'khachhang1@fpt.edu.vn', '0987123456', 'password', 0, N'Hà Nội', N'Cầu Giấy', N'Dịch Vọng', N'101 Đường GHI', 1),
	('754df0f5-30e5-4c3a-bbbf-67decc15687d', 'KH002', N'Phạm Văn E', 'null', '1992-02-02', 'khachhang2@fpt.edu.vn', '0909123456', 'password', 1, N'Hồ Chí Minh', N'Quận 5', N'An Bình', N'202 Đường KLM', 1)
	INSERT INTO khach_hang (id_kh, ma, ten, trang_thai,thanh_pho,sdt)
VALUES
('678ca9e6-f859-48e7-8351-56752b09d5c4', N'KH00', N'Khách hàng lẻ', 0,'Không có','Không có')
