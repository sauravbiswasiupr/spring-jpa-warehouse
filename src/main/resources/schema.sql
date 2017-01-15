CREATE TABLE warehouse (
  id INT IDENTITY  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
);

CREATE TABLE product (
  id INT IDENTITY PRIMARY KEY,
  version INT DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  imageurl VARCHAR(255) DEFAULT NULL,
  price NUMERIC,
  warehouse_id INT,
  FOREIGN KEY (warehouse_id) REFERENCES warehouse (ID)
);