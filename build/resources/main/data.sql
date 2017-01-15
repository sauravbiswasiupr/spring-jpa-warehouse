INSERT INTO warehouse
(name)

VALUES
('Warehouse Atlanta'),
('Warehouse Detroit'),
('Warehouse Boston')
;

insert into product
(version, description, imageurl, price, warehouse_id)
VALUES
(42,
'great product',
'www.super-product.com',
24.5,
(SELECT id from warehouse WHERE name='Warehouse Boston')
);