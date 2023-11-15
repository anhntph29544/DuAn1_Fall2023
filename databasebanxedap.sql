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
	ngay_thanh_toan date,
	tinh_trang int,
	thanh_tien decimal(20)
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