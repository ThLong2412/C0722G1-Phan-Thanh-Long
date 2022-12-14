create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
id_class int primary key auto_increment,
name_class varchar(60) not null,
start_date datetime not null,
status bit );
create table student (
student_id int  primary key auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone varchar (20),
status bit,
id_class int,
foreign key (id_class) references class(id_class));
create table subject (
sub_id int  primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint default 1 check (credit >= 1),
status bit default 1);
create table mark(
mark_id int primary key auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_time tinyint default 1,
unique(sub_id, student_id),
foreign key (sub_id) references subject(sub_id),
foreign key (student_id) references student(student_id));
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1),
 (2, 'A2', '2008-12-22', 1),
 (3, 'B3', current_date, 0);
 INSERT INTO student (student_name, address, phone, status, id_class)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, status, id_class)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, status, id_class)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO mark (sub_id,student_id,mark,exam_time)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
SELECT *FROM student;	
SELECT *
FROM student
WHERE status = true;
SELECT *
FROM subject
WHERE credit < 10;
select student.student_id, student.student_name, class.name_class
from student join class on 	student.id_class = class.id_class
where class.name_class = 'A1';
select student.student_id, student.student_name, subject.sub_name, mark.mark
from student join mark on student.student_id = mark.student_id join subject on subject.sub_id = mark.sub_id
where subject.sub_name = 'CF';
select * from student 
where student_name like 'H%';
select * from class
where month(start_date) = 12;
select * from subject
where credit between 3 and 5;
SET SQL_SAFE_UPDATES = 0; -- t???t ch??? ????? an to??n
update student 
set id_class = 2
where student_name = 'Hung';
select student.student_name , subject.sub_name, mark.mark 
from student join mark on student.student_id = mark.student_id join subject on mark.sub_id = subject.sub_id
order by mark desc , student_name desc;
-- Hi???n th??? s??? l?????ng sinh vi??n ??? t???ng n??i
select address , count(student_id) as 's??? l?????ng h???c vi??n'
from student
group by address;
-- T??nh ??i???m trung b??nh c??c m??n h???c c???a m???i h???c vi??n
select s.student_id, s.student_name,avg(mark)
 from student s join mark on s.student_id = mark.student_id
group by s.student_id, s.student_name;
-- Hi???n th??? nh???ng b???n h???c vi??n co ??i???m trung b??nh c??c m??n h???c l???n h??n 15
select s.student_id, s.student_name,avg(mark)
 from student s join mark on s.student_id = mark.student_id
group by s.student_id, s.student_name
having avg(mark) > 15;
-- Hi???n th??? th??ng tin c??c h???c vi??n c?? ??i???m trung b??nh l???n nh???t.
 select s.student_id, s.student_name,avg(mark)
 from student s join mark on s.student_id = mark.student_id
group by s.student_id, s.student_name
having avg(mark) >= all (select avg(mark) from mark group by mark.student_id);

-- Hi???n th??? t???t c??? c??c th??ng tin m??n h???c (b???ng subject) c?? credit l???n nh???t.
select *, max(credit) from subject;
-- Hi???n th??? c??c th??ng tin m??n h???c c?? ??i???m thi l???n nh???t.
select subject.sub_id,subject.sub_name,subject.credit,subject.status,max(mark) from subject join mark on subject.sub_id = mark.sub_id;
-- Hi???n th??? c??c th??ng tin sinh vi??n v?? ??i???m trung b??nh c???a m???i sinh vi??n, x???p h???ng theo th??? t??? ??i???m gi???m d???n
select student.student_id,student_name,avg(mark)from student
join mark on student.student_id = mark.student_id
group by student.student_id
order by avg(mark) desc;