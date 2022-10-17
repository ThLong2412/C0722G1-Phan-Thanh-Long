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
