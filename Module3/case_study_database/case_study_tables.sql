CREATE DATABASE case_study_module3_tables;
drop DATABASE case_study_module3_tables;

CREATE TABLE position (
id INT PRIMARY KEY,
name VARCHAR(45));
CREATE TABLE education_degree (
id INT PRIMARY KEY,
name VARCHAR(45));
CREATE TABLE division (
id INT PRIMARY KEY,
name VARCHAR(45));
CREATE TABLE employee (
id INT PRIMARY KEY,
name VARCHAR(45),
day_of_birth DATE,
id_card VARCHAR(45),
salary DOUBLE,
 phone_number  VARCHAR(45),
 email  VARCHAR(45),
 address  VARCHAR(45),
position_id INT,
FOREIGN KEY (position_id) REFERENCES `position`(id),
education_degree_id INT,
FOREIGN KEY (education_degree_id) REFERENCES education_degree(id),
division_id INT,
FOREIGN KEY (division_id) REFERENCES division(id));
CREATE TABLE customer_type(
id INT PRIMARY KEY,
name VARCHAR(45));
 CREATE TABLE customer (
id INT PRIMARY KEY,
customer_type_id INT,
FOREIGN KEY (customer_type_id) REFERENCES customer_type(id),
name VARCHAR(45),
day_of_birth DATE,
gender BIT(1),
id_card VARCHAR(45),
 phone_number  VARCHAR(45),
 email  VARCHAR(45),
 address  VARCHAR(45));
 CREATE TABLE facility_type (
 id INT PRIMARY KEY,
 name VARCHAR(45));
 CREATE TABLE rent_type(
 id INT PRIMARY KEY,
 name VARCHAR(45));
 CREATE TABLE facility (
id INT PRIMARY KEY,
 name VARCHAR(45),
 area INT,
 cost DOUBLE,
 max_people INT,
 rent_type_id INT,
  FOREIGN KEY ( rent_type_id) REFERENCES rent_type(id),
 facility_type_id INT,
 FOREIGN KEY ( facility_type_id) REFERENCES facility_type(id),
 standard_room VARCHAR(45),
 descriiption_other_convenience VARCHAR(45),
 pool_area DOUBLE,
 number_of_floors INT,
 facility_free TEXT);
 CREATE TABLE attach_facility (
 id INT PRIMARY KEY,
 name VARCHAR(45),
 cost DOUBLE,
 unit VARCHAR(45),
 status VARCHAR(45));
 CREATE TABLE contract(
 id INT PRIMARY KEY,
 start_date DATETIME,
 end_date DATETIME,
 deposit DOUBLE,
 employee_id INT,
  FOREIGN KEY (employee_id) REFERENCES employee(id),
 customer_id INT,
   FOREIGN KEY (customer_id) REFERENCES customer(id),
 facility_id INT,
  FOREIGN KEY (facility_id) REFERENCES facility(id));
 CREATE TABLE contract_detail (
 id INT PRIMARY KEY,
 quantity INT,
 contract_id INT,
 FOREIGN KEY (contract_id) REFERENCES contract(id),
 attach_facility_id INT,
  FOREIGN KEY (attach_facility_id) REFERENCES attach_facility(id)
 );
 
