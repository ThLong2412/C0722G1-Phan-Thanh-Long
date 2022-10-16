create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh (
ma_hs varchar(20) primary key,
ten_hs varchar(45),
ngay_sinh datetime,
lop varchar(20),
gioi_tinh varchar(20));
create table mon_hoc (
ma_mh varchar(20) primary key,
ten_mh varchar(45));
create table bang_diem(
ma_hs VARCHAR(20),
ma_mh VARCHAR(20),
diem_thi INT,
ngay_thi DATETIME,
PRIMARY KEY (ma_hs, ma_mh),
FOREIGN KEY (ma_hs) REFERENCES hoc_sinh(ma_hs),
FOREIGN KEY (ma_mh) REFERENCES mon_hoc(ma_mh)
);
create table giao_vien (
ma_gv varchar(20) primary key,
ten_gv varchar(45),
so_dien_thoai varchar (20));
alter table mon_hoc 
add ma_gv varchar(20);
alter table mon_hoc 
add constraint fk_ma_gv foreign key (ma_gv) references giao_vien(ma_gv);