create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(45),
c_age int);
create table orders(
o_id int  primary key,
c_id int not null, 
foreign key (c_id) references customer(c_id),
o_date date,
o_total_price varchar(45));
create table product (
p_id int primary key,
p_name varchar(45),
p_price varchar(45));
create table order_detail (
o_id int,
p_id int,
primary key(o_id, p_id),
foreign key (o_id) references orders(o_id),
foreign key (p_id) references product(p_id),
od_qty varchar(45));

