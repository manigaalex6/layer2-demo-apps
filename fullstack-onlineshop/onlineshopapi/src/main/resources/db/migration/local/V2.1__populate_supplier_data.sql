INSERT INTO suppliers (id, name, contact_email, phone)
VALUES ('50ff0001-0000-0000-0000-000000000001', 'TechVision Electronics', 'sales@techvision.com', '+40-21-555-0101'),
       ('50ff0002-0000-0000-0000-000000000002', 'FashionForward Apparel', 'orders@fashionforward.com', '+40-21-555-0102'),
       ('50ff0003-0000-0000-0000-000000000003', 'HomeBase Supplies', 'contact@homebase.com', '+40-21-555-0103'),
       ('50ff0004-0000-0000-0000-000000000004', 'SportsPro Gear', 'info@sportsprogear.com', '+40-21-555-0104');

UPDATE products SET supplier_id = '50ff0001-0000-0000-0000-000000000001' WHERE category_id = 'ca7e0001-0000-0000-0000-000000000001';
UPDATE products SET supplier_id = '50ff0002-0000-0000-0000-000000000002' WHERE category_id = 'ca7e0002-0000-0000-0000-000000000002';
UPDATE products SET supplier_id = '50ff0003-0000-0000-0000-000000000003' WHERE category_id = 'ca7e0003-0000-0000-0000-000000000003';
UPDATE products SET supplier_id = '50ff0004-0000-0000-0000-000000000004' WHERE category_id = 'ca7e0004-0000-0000-0000-000000000004';

ALTER TABLE products ALTER COLUMN supplier_id SET NOT NULL;
