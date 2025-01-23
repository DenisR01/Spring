SET @c1 = 1;
INSERT INTO clients (id, email) VALUES (@c1, 'client1@example.com');

SET @c2 = 2;
INSERT INTO clients (id, email) VALUES (@c2, 'client2@example.com');

SET @c3 = 3;
INSERT INTO clients (id, email) VALUES (@c3, 'client3@example.com');

-- Inserare în tabelul products
SET @p1 = 1;
INSERT INTO products (id, name) VALUES (@p1, 'Cremă hidratantă');

SET @p2 = 2;
INSERT INTO products (id, name) VALUES (@p2, 'Ruj roșu');

SET @p3 = 3;
INSERT INTO products (id, name) VALUES (@p3, 'Șampon nutritiv');

-- Inserare în tabelul orders
SET @o1 = 1;
INSERT INTO orders (id, state, client_id) VALUES (@o1, 'registered', @c1);

SET @o2 = 2;
INSERT INTO orders (id, state, client_id) VALUES (@o2, 'ready', @c2);

SET @o3 = 3;
INSERT INTO orders (id, state, client_id) VALUES (@o3, 'delivered', @c3);

-- Inserare în tabelul order_products
INSERT INTO order_products (product_id, order_id) VALUES (@p1, @o1);
INSERT INTO order_products (product_id, order_id) VALUES (@p2, @o1);
INSERT INTO order_products (product_id, order_id) VALUES (@p2, @o2);
INSERT INTO order_products (product_id, order_id) VALUES (@p3, @o3);