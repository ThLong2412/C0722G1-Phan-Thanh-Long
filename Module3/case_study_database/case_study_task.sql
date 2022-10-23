CREATE DATABASE case_study_task;
USE case_study_task;
USE case_study_module3_tables;

-- TASK 2
select * from nhan_vien
where ((ho_ten like 'H%')|( ho_ten like 'K%' )|( ho_ten like 'T%')) and char_length(ho_ten) <=15 ;

-- TASK 3
select * from khach_hang 
where ((datediff(curdate(),ngay_sinh )) / 365 > 18) and ((datediff(curdate(),ngay_sinh )) / 365 < 50) and ((dia_chi like '%Đà Nẵng%') | (dia_chi like '%Quảng Trị%'));

-- TASK 4
select kh.ho_ten, hd.ma_khach_hang, count(hd.ma_khach_hang) as so_luong_dat_phong
from khach_hang kh join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ma_loai_khach = 1
group by hd.ma_khach_hang
order by so_luong_dat_phong;

-- TASK 5
	select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
    (ifnull(dv.chi_phi_thue,0) + ifnull(hdct.so_luong,0)  * ifnull(dvdk.gia,0)) as tong_tien
	from khach_hang kh 
	left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach 
	left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
	left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
	left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
	left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
	group by  hd.ma_hop_dong, kh.ma_khach_hang
	order by ma_khach_hang ;
    
-- TASK 6
select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu , hop_dong.ngay_lam_hop_dong
from loai_dich_vu 
join dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where hop_dong.ma_dich_vu not in (
select hop_dong.ma_dich_vu
from hop_dong 
where (year(hop_dong.ngay_lam_hop_dong) = 2021 and month(hop_dong.ngay_lam_hop_dong) in (1,2,3))
)
group by dich_vu.ma_dich_vu;

-- TASK 7
select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from loai_dich_vu 
join dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where hop_dong.ma_dich_vu not in (
select hop_dong.ma_dich_vu 
from hop_dong 
where (year(hop_dong.ngay_lam_hop_dong) = 2021)) and year(hop_dong.ngay_lam_hop_dong) = 2020
group by dich_vu.ma_dich_vu;

-- TASK 8
 -- cách 1 dùng distinct (khách hàng đặt 1 lần)
select distinct khach_hang.ho_ten
from khach_hang join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
having count(hop_dong.ma_khach_hang);
-- cách 2 dùng union
SELECT ho_ten
FROM khach_hang
UNION
SELECT ho_ten
FROM khach_hang;
-- cách 3 dùng goup by
select khach_hang.ho_ten
from khach_hang group by ho_ten;

-- TASK 9
select month(hop_dong.ngay_lam_hop_dong) as month, count(hop_dong.ma_hop_dong) as so_luong_khach_hang 
from hop_dong
where ( year(hop_dong.ngay_lam_hop_dong) = 2021)
group by month(hop_dong.ngay_lam_hop_dong)
order by month(hop_dong.ngay_lam_hop_dong);

-- TASK 10
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by hd.ma_hop_dong;
 
 -- TAASK 11
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from khach_hang kh 
left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and ((kh.dia_chi like '%Vinh%') or (kh.dia_chi like '%Quảng Trị%'));
 
 -- TASK 12
 create view w_task12 
 as select hd.ma_hop_dong 	
 from hop_dong hd 
 where year(hd.ngay_lam_hop_dong) = 2021 and month(hd.ngay_lam_hop_dong) between 1 and 6;
 select hd.ma_hop_dong, nv.ho_ten,kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu,sum(hdct.so_luong) as so_luong_dich_vu_di_kem,hd.tien_dat_coc
 from hop_dong hd left join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang 
 left join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien 
 left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
 left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
 where hd.ma_hop_dong not in (
 select * from w_task12) 
 and (year(hd.ngay_lam_hop_dong) = 2020 and month(hd.ngay_lam_hop_dong) in (11,12,13))
 group by hd.ma_hop_dong;
 
 -- TASK 13	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
create view w_task13 as
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
group by ma_dich_vu_di_kem
order by sum(hdct.so_luong) desc;
select * from w_task13
where so_luong_dich_vu_di_kem = (select max(so_luong_dich_vu_di_kem) from w_task13) ;

-- TASK 14
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
 join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
 join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
 join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
 join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 group by dvdk.ma_dich_vu_di_kem
having count(dvdk.ma_dich_vu_di_kem) = 1
order by hd.ma_hop_dong;

-- TASK 15
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi, count(hop_dong.ma_nhan_vien) as so_lan_lam_hop_dong
from nhan_vien join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien 
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
where year(hop_dong.ngay_lam_hop_dong) in (2020,2021)
group by hop_dong.ma_nhan_vien
having count(hop_dong.ma_nhan_vien) <= 3
order by nhan_vien.ma_nhan_vien;

-- TASK 16 Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
create view w_task16 as
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten from nhan_vien join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) in (2019,2021)
group by nhan_vien.ma_nhan_vien;
delete from nhan_vien
where nhan_vien.ma_nhan_vien not in (
select w_task16.ma_nhan_vien from w_task16);

-- TASK 17
create view tong_thanh_toan_2021 as
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
    (ifnull(dv.chi_phi_thue,0) + ifnull(hdct.so_luong,0)  * ifnull(dvdk.gia,0)) as tong_tien
	from khach_hang kh 
	left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach 
	left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
	left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
	left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
	left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
    where year(hd.ngay_lam_hop_dong) = 2021 and  (ifnull(dv.chi_phi_thue,0) + ifnull(hdct.so_luong,0)  * ifnull(dvdk.gia,0))  > 10000000
	group by  hd.ma_hop_dong, kh.ma_khach_hang
	order by ma_khach_hang ;
create view w_task17 as
select khach_hang.ma_khach_hang, loai_khach.ten_loai_khach from 
khach_hang join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach;
SET SQL_SAFE_UPDATES = 0; -- tắt chế độ an toàn
SET SQL_SAFE_UPDATES = 1; -- bật chế độ an toàn
update w_task17
set w_task17.ten_loai_khach = 'Diamond'
where w_task17.ten_loai_khach = 'Platinum'
and (w_task17.ma_khach_hang in (select tong_thanh_toan_2021.ma_khach_hang from tong_thanh_toan_2021));
-- TASK 18 (00-11)
create view w_task18 as
select khach_hang.ma_khach_hang, khach_hang.ho_ten, hop_dong.ngay_lam_hop_dong 
from khach_hang join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) < 2021 
group by khach_hang.ma_khach_hang;
SET foreign_key_checks = 0; 
SET foreign_key_checks = 1; 
delete from khach_hang 
where khach_hang.ma_khach_hang in (select w_task18.ma_khach_hang from w_task18);

-- TASK 19
create view w_task19 as
select dvdk.ma_dich_vu_di_kem
from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem 
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
where year(hd.ngay_lam_hop_dong) = 2020
group by dvdk.ten_dich_vu_di_kem
having sum(hdct.so_luong) > 10;
SET SQL_SAFE_UPDATES = 0;
update dich_vu_di_kem
set gia = gia * 2
where ma_dich_vu_di_kem in (
select * from w_task19
);

-- TASK 20
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.email,nhan_vien.so_dien_thoai, nhan_vien.ngay_sinh, nhan_vien.dia_chi 
from nhan_vien
union all
select khach_hang.ma_khach_hang, khach_hang.ho_ten,khach_hang.email, khach_hang.so_dien_thoai, khach_hang.ngay_sinh, khach_hang.dia_chi
from khach_hang;

-- TASK 21
create view v_nhan_vien as
select * from nhan_vien 
where dia_chi like '%Đà Nẵng%';
-- TASK 22
SET SQL_SAFE_UPDATES = 1;
update v_nhan_vien 
set dia_chi = 'Liên Chiểu';
-- TASK 23
Delimiter //
create procedure sp_xoa_khach_hang (p_id int)
    begin
    delete from khach_hang
    where khach_hang.ma_khach_hang = p_id;
   end //
DELIMITER ;
 call sp_xoa_khach_hang(2);
-- TASK 24
Delimiter //
create procedure sp_them_moi_hop_dong(id int, ngay_lam_hop_dong datetime, ngay_ket_thuc datetime, tien_dat_coc double, ma_nhan_vien int, ma_khach_hang int, ma_dich_vu int)
    begin
    insert into hop_dong
    value (id,ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,ma_nhan_vien,ma_khach_hang, ma_dich_vu);
   end //
DELIMITER ;
call sp_them_moi_hop_dong(13,'2021-12-15','2022-01-01',150000,3,5,1);

-- TASK 25
create table so_luong_hop_dong_sau_khi_xoa (
so_luong int);
Delimiter //
create trigger tr_xoa_hop_dong 
after delete on hop_dong
for each row 
begin
 insert into so_luong_hop_dong_sau_khi_xoa 
 value (count(hop_dong.ma_hop_dong));
end // 
Delimiter ;
select * from so_luong_hop_dong_sau_khi_xoa;
SET SQL_SAFE_UPDATES = 0;
delete from hop_dong 
where ma_hop_dong = 13;
Delimiter //
create procedure sp_xoa_hop_dong (p_id int)
    begin
    delete from hop_dong
    where hop_dong.ma_hop_dong = p_id;
   end //
DELIMITER ;
 call sp_xoa_hop_dong(13);
