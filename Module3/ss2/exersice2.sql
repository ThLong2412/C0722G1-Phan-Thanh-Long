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
insert into customer 
value (1, 'Minh Quan', 10),
(2, 'Ngoc Oanh',20),
(3, 'Hong Ha',50);
insert into orders(o_id,c_id,o_date)
value (1,1,'2006-03-21'),
(2,2,'2006-03-23'),
(3,1,'2006-03-16');
insert into product
value (1, 'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
insert into order_detail 
value (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id,o_date,o_total_price 
from orders;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.c_id, customer.c_name,orders.o_id,order_detail.p_id,product.p_name
from customer join orders on customer.c_id = orders.c_id join order_detail on orders.o_id = order_detail.o_id join product on order_detail.p_id = product.p_id ;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.c_id, customer.c_name, orders.o_id
from customer left join orders on customer.c_id = orders.c_id
where orders.c_id is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select orders.o_id, orders.o_date, order_detail.od_qty * product.p_price as tatol
from orders join order_detail on orders.o_id = order_detail.o_id join product on order_detail.p_id = product.p_id;