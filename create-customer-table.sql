USE salesman;

CREATE TABLE customer (
   customer_id INT NOT NULL AUTO_INCREMENT,
   customer_name VARCHAR(30) NOT NULL,
   customer_address VARCHAR(30) NOT NULL,
   customer_phone VARCHAR(10) NOT NULL,
   PRIMARY KEY (customer_id)
);