create database demo;
use demo;
create table products(
id int primary key,
product_code int,
product_name varchar(45),
product_price int,
product_amount int,
product_description varchar(45),
product_status varchar(45));
insert into products 
value (1,001,'Sách giáo khoa',10,1,'abcxyz','mới'),
(2,002,'Vở ghi',4,5,'96 trang','mới'),
(3,003,'Bút',2,3,'Mực xanh','mới');
create unique index user_index_1 
on products (product_code);
create unique index user_index_2 
on products (product_name, product_price);
explain select * from products;
create view view_products as
select product_code, product_name, product_price, product_status
from products;
set SQL_SAFE_UPDATES = 0;
update view_products 
set product_status = 'chất lượng trung'
where view_products.product_code = 1;
drop view view_products;
Delimiter //
create procedure p_get_all_product()
    begin
    select * from products;
   end //
DELIMITER ;

call p_get_all_product();

Delimiter //
create procedure add_product()
    begin
    insert into products
    value (4,004,'Thước',4,3,'20cm','màu đen');
   end //
DELIMITER ;
call add_product();
Delimiter //
create procedure update_product(p_id int)
    begin
    update products 
    set products.product_name = 'Giấy kiểm tra'
    where products.id = p_id;
   end //
DELIMITER ;
call update_product(1);
Delimiter //
create procedure delete_product(p_id int)
    begin
    delete from products
    where products.id = p_id;
   end //
DELIMITER ;
call delete_product(3);