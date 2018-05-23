--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 10.1

-- Started on 2018-05-23 23:30:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2165 (class 0 OID 16521)
-- Dependencies: 190
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (1, NULL, 'Пример', '2018-02-14');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (2, NULL, 'Департамент 2', '2016-01-20');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (3, 1, 'Департамент 3', '2016-01-25');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (4, 1, 'Департамент 4', '2016-01-29');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (5, 2, 'Департамент 5', '2016-02-11');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (6, 2, 'Департамент 6', '2016-02-20');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (7, 3, 'Департамент 7', '2016-02-24');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (8, 4, 'Департамент 8', '2016-02-29');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (9, 5, 'Департамент 9', '2016-03-11');
INSERT INTO department (id, idparentdepartment, name, datecreation) VALUES (10, 9, 'Департамент 10', '2016-03-20');


--
-- TOC entry 2167 (class 0 OID 16542)
-- Dependencies: 192
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (1, 2, 'Иван', 'Иванов', NULL, 'м', '1987-03-23', '8912345678', 'example@mail.ru', '2016-11-23', NULL, 67876, true, 1);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (2, 1, 'Руслан', 'Мингазов', NULL, 'м', '1988-03-23', '8912345678', 'example@mail.ru', '2016-11-23', NULL, 34234, false, 1);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (3, 5, 'Александр', 'Тихонов', NULL, 'м', '1988-04-23', '8912345678', 'example@mail.ru', '2016-11-23', NULL, 29856, false, 1);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (4, 2, 'Каюпов', 'Анвар', NULL, 'м', '1988-04-21', '8912345678', 'example@mail.ru', '2016-11-23', NULL, 58938, true, 2);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (5, 3, 'Печерин', 'Алексей', NULL, 'м', '1988-04-21', '8912345678', 'example@mail.ru', '2016-11-23', NULL, 32134, false, 2);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (6, 4, 'Сергей', 'Тополин', NULL, 'м', '1988-04-21', '8912783678', 'example@mail.ru', '2016-11-23', NULL, 26878, false, 2);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (7, 4, 'Владимер', 'Чукманов', NULL, 'м', '1984-04-11', '8912783678', 'example@mail.ru', '2016-11-23', NULL, 22323, false, 3);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (8, 2, 'Оксана', 'Малышев', NULL, 'ж', '1985-04-15', '8912783678', 'example@mail.ru', '2016-11-23', NULL, 54345, true, 3);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (9, 1, 'Виталий', 'Супремо', NULL, 'м', '1985-04-15', '8912783678', 'example@mail.ru', '2016-11-23', NULL, 39878, false, 3);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (10, 2, 'Дмитрий', 'Уточкин', NULL, 'м', '1995-04-15', '8445789678', 'example@mail.ru', '2016-11-23', NULL, 57446, true, 4);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (11, 3, 'Семен', 'Павлов', NULL, 'м', '1991-04-15', '8445789678', 'example@mail.ru', '2016-11-23', NULL, 23442, false, 4);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (12, 2, 'Вася', 'Пупкин', NULL, 'м', '1991-02-15', '8445789708', 'agent@mail.ru', '2017-11-23', NULL, 74533, true, 5);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (13, 2, 'Андрей', 'Демшев', NULL, 'м', '1997-02-15', '8445789708', 'agent01@mail.ru', '2017-12-23', NULL, 67323, true, 6);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (14, 4, 'Вячеслав', 'Винчестер', NULL, 'м', '1990-02-12', '8445789708', 'agent01@mail.ru', '2018-12-23', NULL, 32433, false, 6);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (15, 2, 'Люцифер', 'Диница', 'Око', 'м', '1990-01-12', '8445789708', 'agent11@mail.ru', '2018-05-13', NULL, 54234, true, 7);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (16, 1, 'Денис', 'Сорокин', NULL, 'м', '1996-01-12', '8445789708', 'agentik@mail.ru', '2018-05-13', NULL, 28908, false, 7);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (17, 2, 'Элеанора', 'Газинуровна', NULL, 'ж', '1992-01-12', '8445789708', 'agentik@mail.ru', '2018-05-13', NULL, 44543, true, 8);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (18, 1, 'Марсель', 'Каримов', NULL, 'м', '1994-01-11', '8445789708', 'postrik@mail.ru', '2018-05-13', NULL, 28938, false, 8);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (19, 2, 'Сэм', 'Винчестер', NULL, 'м', '1994-01-11', '8445789708', 'vinchik@mail.ru', '2018-05-13', NULL, 56434, true, 9);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (20, 2, 'Тирион', 'Ланестер', NULL, 'м', '1987-01-11', '8445789708', 'vinchik@mail.ru', '2018-05-13', NULL, 63475, true, 10);
INSERT INTO employee (id, idpost, firstname, secondname, thirdname, floor, birthdate, contactnumber, email, reception, layoff, salary, head, iddepartment) VALUES (21, 1, 'Денис', 'Афанасьев', NULL, 'м', '1987-01-11', '8445789708', 'denchik@mail.ru', '2018-05-13', NULL, 32444, false, 10);


--
-- TOC entry 2168 (class 0 OID 16560)
-- Dependencies: 193
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2169 (class 0 OID 16568)
-- Dependencies: 194
-- Data for Name: fund; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (1, 131966, 1);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (2, 117950, 2);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (3, 116546, 3);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (4, 80888, 4);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (5, 74533, 5);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (6, 99756, 6);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (7, 83142, 7);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (8, 73481, 8);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (9, 56434, 9);
INSERT INTO fund (id, salarydepartment, iddepartment) VALUES (10, 95919, 10);


--
-- TOC entry 2166 (class 0 OID 16534)
-- Dependencies: 191
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO post (id, name) VALUES (1, 'Руководитель');
INSERT INTO post (id, name) VALUES (2, 'Главный руководитель');
INSERT INTO post (id, name) VALUES (3, 'Тестировщик');
INSERT INTO post (id, name) VALUES (4, 'Системный администратор');
INSERT INTO post (id, name) VALUES (5, 'Бугалтер');


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 189
-- Name: nextiddepartment; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nextiddepartment', 10, true);


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 188
-- Name: nextidemployee; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nextidemployee', 21, true);


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 185
-- Name: nextidevent; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nextidevent', 1, false);


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 186
-- Name: nextidfond; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nextidfond', 10, true);


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 187
-- Name: nextidpost; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nextidpost', 5, true);


-- Completed on 2018-05-23 23:30:44

--
-- PostgreSQL database dump complete
--

