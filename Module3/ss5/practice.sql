CREATE OR REPLACE VIEW view_name AS
SELECT column1, column2
FROM table_name ; -- tạo view
CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes'; 
DROP VIEW customer_views;
