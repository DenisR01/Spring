SET @c1 = 1;
INSERT INTO clients (id, name,mail) VALUES (@c1,'Client1', 'client1@example.com');

SET @c2 = 2;
INSERT INTO clients (id,name, mail) VALUES (@c2,'Client2', 'client2@example.com');

SET @c3 = 3;
INSERT INTO clients (id,name, mail) VALUES (@c3,'Client3', 'client3@example.com');

-- Inserare în tabelul products
SET @p1 = 1;
INSERT INTO products (id, name) VALUES (@p1, 'Pantof costum');

SET @p2 = 2;
INSERT INTO products (id, name) VALUES (@p2, 'Stiletto');

SET @p3 = 3;
INSERT INTO products (id, name) VALUES (@p3, 'Pantof Burgundi');

-- Inserare în tabelul orders
SET @o1 = 1;
INSERT INTO orders (id, state, client_id) VALUES (@o1, 'preluata', @c1);

SET @o2 = 2;
INSERT INTO orders (id, state, client_id) VALUES (@o2, 'pregatita', @c2);

SET @o3 = 3;
INSERT INTO orders (id, state, client_id) VALUES (@o3, 'platita', @c3);

-- Inserare în tabelul order_products
INSERT INTO order_products (product_id, order_id) VALUES (@p1, @o1);
INSERT INTO order_products (product_id, order_id) VALUES (@p2, @o1);
INSERT INTO order_products (product_id, order_id) VALUES (@p2, @o2);
INSERT INTO order_products (product_id, order_id) VALUES (@p3, @o3);