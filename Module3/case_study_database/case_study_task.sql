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
