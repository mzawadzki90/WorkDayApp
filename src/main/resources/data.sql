INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (1, 'Jan', 'Kowalski', 'REGULAR_EMPLOYEE', 'jan.kowalski@test.pl');
INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (1, 1, 'jan.kowalski', 'test1234');

INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (2, 'Tomasz', 'Nowak', 'DIRECTOR', 'tomasz.nowak@test.pl');
INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (2, 2, 'tomasz.nowak', 'test4321')