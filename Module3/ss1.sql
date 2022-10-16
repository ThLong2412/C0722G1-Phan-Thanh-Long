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
id INT primary key,
name VARCHAR(100),
age INT, 
country VARCHAR(100) );
CREATE TABLE name_class (
id INT, 
nameclass VARCHAR (100) );
USE teacher;
SELECT * FROM teacher;
INSERT INTO teacher
VALUE (1, 'Long',18, 'Quảng Trị'), (2,'Nam',15,'Tuyên Quang');
ALTER TABLE teacher
ADD score INT;
SET SQL_SAFE_UPDATES = 0; -- tắt chế độ an toàn
UPDATE teacher 
SET score = 10
WHERE id <= 2;
SET SQL_SAFE_UPDATES = 1; -- bật chế độ an toàn
INSERT INTO teacher
VALUE (3, 'Long2',17, 'Quảng Trị',10), (4,'Nam2',16,'Tuyên Quang',5);	
DELETE FROM teacher 
WHERE id = 4; 
USE student;
SELECT * FROM name_class;
ALTER TABLE name_class 
DROP COLUMN classes;
INSERT INTO name_class 
VALUE (1, 'C07'), (2, 'C08');
SELECT * FROM student;
ALTER TABLE student
ADD classes INT;
INSERT INTO student
VALUE (3,' LONG',18,'QUẢNG TRỊ',2) ;

SELECT  student.id,student.name,student.age,student.country,name_class.nameclass
FROM student, name_class
WHERE name_class.id = student.classes;
-- XÓA BẢNG CLASS
-- DROP TABLE class;