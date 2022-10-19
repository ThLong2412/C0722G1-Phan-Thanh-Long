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
 -- cách 1
select distinct khach_hang.ho_ten
from khach_hang join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
having count(hop_dong.ma_khach_hang);
-- cách 2
-- cách 3

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
 
 
