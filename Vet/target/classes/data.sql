SET @c1 = 1;
INSERT INTO clients (id, nume) VALUES (@c1, 'Client1');

SET @c2 = 2;
INSERT INTO clients (id, nume) VALUES (@c2, 'Client2');

SET @c3 = 3;
INSERT INTO clients (id, nume) VALUES (@c3, 'Client3');

-- Inserare în tabelul employees
SET @e1 = 1;
INSERT INTO employees (id, name) VALUES (@e1, 'Employee1');

SET @e2 = 2;
INSERT INTO employees (id, name) VALUES (@e2, 'Employee2');

SET @e3 = 3;
INSERT INTO employees (id, name) VALUES (@e3, 'Employee3');

-- Inserare în tabelul requests
SET @r1 = 1;
INSERT INTO requests (id, location, descriere, state, client_id, employee_id) VALUES (@r1, 'New York', 'Request 1 Description', 'pending', @c1, @e1);

SET @r2 = 2;
INSERT INTO requests (id, location, descriere, state, client_id, employee_id) VALUES (@r2, 'Los Angeles', 'Request 2 Description', 'started', @c2, @e2);

SET @r3 = 3;
INSERT INTO requests (id, location, descriere, state, client_id, employee_id) VALUES (@r3, 'Chicago', 'Request 3 Description', 'completed', @c3, @e3);