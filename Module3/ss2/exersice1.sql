create database quan_ly_hang_hoa;
use quan_ly_hang_hoa;
create table phieu_xuat (
so_px int primary key,
ngay_xuat date);
create table vat_tu(
ma_vt int primary key,
ten_vt varchar(45));
create table chi_tiet_phieu_xuat(
so_px int,
ma_vt int,
primary key(so_px, ma_vt),
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vt) references vat_tu(ma_vt),
don_gia_xuat varchar(45),
so_luong_xuat varchar(45));
create table phieu_nhap (
so_pn int primary key,
ngay_nhap date);
create table chi_tiet_phieu_nhap(
so_pn int,
ma_vt int,
primary key(so_pn, ma_vt),
foreign key (so_pn) references phieu_nhap(so_pn),
foreign key (ma_vt) references vat_tu(ma_vt),
don_gia_nhap varchar(45),
so_luong_nhap varchar(45));
create table don_dat_hang(
so_don_hang int primary key,
ngay_dat_hang date);
create table chi_tiet_don_dat_hang(
ma_vt int,
so_don_hang int,
primary key(ma_vt,so_don_hang),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_don_hang) references don_dat_hang(so_don_hang));
create table nha_cung_cap (
ma_ncc int primary key,
ten_ncc varchar(45),
dia_chi varchar(45));
create table so_dien_thoai(
id int primary key auto_increment,
so_dien_thoai varchar(45),
sdt_id int,
foreign key (sdt_id) references nha_cung_cap(ma_ncc));
create table cung_cap(
so_don_hang int,
ma_ncc int,
primary key (so_don_hang, ma_ncc),
foreign key (so_don_hang) references don_dat_hang(so_don_hang),
foreign key (ma_ncc) references nha_cung_cap (ma_ncc));









