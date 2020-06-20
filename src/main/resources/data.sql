INSERT INTO department(id, name)
VALUES (1, 'Dział Rozwoju Multimediów');

INSERT INTO team(id, name)
VALUES (1, 'Zespół rozwoju Aplikacji');

INSERT INTO position(id, name)
VALUES (1, 'Programista');

INSERT INTO position(id, name)
VALUES (2, 'Dyrektor Operacyjny');

INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (1, 'Jan', 'Kowalski', 'REGULAR_EMPLOYEE', 'jan.kowalski@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (1, 1, 'jan.kowalski', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (1, '2017-01-01', NULL, 1, 1, 1, 1);

INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (2, 'Tomasz', 'Nowak', 'DIRECTOR', 'tomasz.nowak@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (2, 2, 'tomasz.nowak', 'test4321');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (2, '2015-01-01', NULL, 2, 1, 1, 2);

UPDATE worker
SET supervisor_id =2
WHERE id = 1;