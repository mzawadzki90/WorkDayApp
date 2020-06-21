INSERT INTO department(id, name)
VALUES (1, 'Dział Rozwoju Multimediów');

INSERT INTO team(id, name)
VALUES (1, 'Zespół rozwoju Aplikacji');


INSERT INTO position(id, name)
VALUES (1, 'Programista');

INSERT INTO position(id, name)
VALUES (2, 'Dyrektor Operacyjny');

INSERT INTO position(id, name)
VALUES (3, 'Tester Aplikacji');

INSERT INTO position(id, name)
VALUES (4, 'Dev-Ops');


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (1, 'Jan', 'Kowalski', 'REGULAR_EMPLOYEE', 'jan.kowalski@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (1, 1, 'jan.kowalski', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (1, '2017-01-01', NULL, 1, 1, 1, 1);


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (2, 'Tomasz', 'Nowak', 'DIRECTOR', 'tomasz.nowak@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (2, 2, 'tomasz.nowak', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (2, '2015-01-01', NULL, 2, 1, 1, 2);


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (3, 'Anna', 'Wiśniewska', 'REGULAR_EMPLOYEE', 'anna.wisniewska@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (3, 3, 'anna.wisniewska', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (3, '2018-01-01', NULL, 3, 1, 1, 3);


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (4, 'Jacek', 'Ogórek', 'REGULAR_EMPLOYEE', 'jacek.ogorek@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (4, 4, 'jacek.ogorek', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (4, '2019-01-01', NULL, 4, 1, 1, 4);


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (5, 'Joanna', 'Wróbel', 'REGULAR_EMPLOYEE', 'joanna.wrobel@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (5, 5, 'joanna.wrobel', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (5, '2017-06-01', NULL, 1, 1, 1, 5);


INSERT INTO worker(id, first_name, last_name, role, email)
VALUES (6, 'Michał', 'Popiołek', 'REGULAR_EMPLOYEE', 'michal.popiolek@test.pl');

INSERT INTO worker_credentials(id, worker_id, login, password)
VALUES (6, 6, 'michal.popiolek', 'test1234');

INSERT INTO occupation(id, since, till, position_id, department_id, team_id, worker_id)
VALUES (6, '2018-06-01', NULL, 1, 1, 1, 6);

UPDATE worker
SET supervisor_id =2
WHERE id IN (1, 3, 4, 5, 6);