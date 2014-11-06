INSERT INTO users (user_id, username, email, password, first_name, last_name, patronymic, birth_date, self_information, address_id) VALUES (1, 'ivan_ivanov', 'ivan.ivanov@gmail.com', '$2a$10$y3AQFROjQPsLbt3x1TlEL.SOlhVG9MWRWAYN.V.P81bHc40LpY7ru', 'Ivan', 'Ivanov', NULL, '1995-01-01', NULL, NULL);
INSERT INTO users (user_id, username, email, password, first_name, last_name, patronymic, birth_date, self_information, address_id) VALUES (2, 'petr_petrov', 'petr.petrov@gmail.com', '$2a$10$y3AQFROjQPsLbt3x1TlEL.SOlhVG9MWRWAYN.V.P81bHc40LpY7ru', 'Petr', 'Petrov', NULL, '1994-02-02', NULL, NULL);
INSERT INTO users (user_id, username, email, password, first_name, last_name, patronymic, birth_date, self_information, address_id) VALUES (3, 'semen_semenov', 'semen.semenov@gmail.com', '$2a$10$y3AQFROjQPsLbt3x1TlEL.SOlhVG9MWRWAYN.V.P81bHc40LpY7ru', 'Semen', 'Semenov', NULL, '1974-02-02', NULL, NULL);
INSERT INTO users (user_id, username, email, password, first_name, last_name, patronymic, birth_date, self_information, address_id) VALUES (4, 'vladimir_vladimirov', 'vladimir.vladimirov@gmail.com', '$2a$10$y3AQFROjQPsLbt3x1TlEL.SOlhVG9MWRWAYN.V.P81bHc40LpY7ru', 'Vladimir', 'Vladimirov', NULL, '1964-04-04', NULL, NULL);

INSERT INTO students (student_id, start_year, graduation_year) VALUES (1, 2014, 2019);
INSERT INTO students (student_id, start_year, graduation_year) VALUES (2, 2013, 2018);

INSERT INTO teachers (teacher_id, position) VALUES (3, 'Head of department');
INSERT INTO teachers (teacher_id, position) VALUES (4, 'Lector');