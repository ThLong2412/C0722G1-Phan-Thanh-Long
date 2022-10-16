create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
id_class int not null primary key auto_increment,
name_class varchar(60) not null,
start_date datetime not null,
status bit );
create table student (
student_id int not null primary key auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone varchar (20),
status bit,
id_class int not null,
foreign key (id_class) references class(id_class));
create table subject (
sub_id int not null primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint default 1 check (credit >= 1),
status bit default 1);
create table mark(
mark_id int not null primary key auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_time tinyint default 1,
unique(sub_id, student_id),
foreign key (sub_id) references subject(sub_id),
foreign key (student_id) references student(student_id));

