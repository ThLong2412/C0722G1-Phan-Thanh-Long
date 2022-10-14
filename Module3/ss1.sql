CREATE DATABASE ss1;
USE ss1;
CREATE TABLE student (
id INT,
name VARCHAR(100),
age INT, 
country VARCHAR(100) );
CREATE TABLE class (
id INT,
name VARCHAR(45) );
CREATE TABLE teacher (
id INT,
name VARCHAR(100),
age INT, 
country VARCHAR(100) );
USE teacher;
SELECT * FROM teacher;
INSERT INTO teacher
VALUE (1, 'Long',18, 'Quảng Trị'), (2,'Nam',15,'Tuyên Quang');
ALTER TABLE teacher
ADD score INT;
SET SQL_SAFE_UPDATES = 0;
UPDATE teacher 
SET score = 10
WHERE id <= 2;
INSERT INTO teacher
VALUE (3, 'Long2',17, 'Quảng Trị',10), (4,'Nam2',16,'Tuyên Quang',5);
-- XÓA BẢNG CLASS
-- DROP TABLE class;