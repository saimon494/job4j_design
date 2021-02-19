CREATE TABLE company
(
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id         integer NOT NULL,
    name       character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company(id, name)
values (1, 'Google');
insert into company(id, name)
values (2, 'Sberbank');
insert into company(id, name)
values (3, 'Yandex');
insert into company(id, name)
values (4, 'Ikea');
insert into company(id, name)
values (5, 'Vtb');

insert into person(id, name, company_id)
values (1, 'Harry', 1);
insert into person(id, name, company_id)
values (2, 'Oliver', 1);
insert into person(id, name, company_id)
values (3, 'Lily', 1);
insert into person(id, name, company_id)
values (4, 'Heather', 1);
insert into person(id, name, company_id)
values (5, 'Olivia', 2);
insert into person(id, name, company_id)
values (6, 'Thomas', 2);
insert into person(id, name, company_id)
values (7, 'Matthew', 2);
insert into person(id, name, company_id)
values (8, 'Grace', 3);
insert into person(id, name, company_id)
values (9, 'Ethan', 3);
insert into person(id, name, company_id)
values (10, 'Ryen', 3);
insert into person(id, name, company_id)
values (11, 'Alexander', 3);
insert into person(id, name, company_id)
values (12, 'Mia', 4);
insert into person(id, name, company_id)
values (13, 'Lucy', 4);
insert into person(id, name, company_id)
values (14, 'Noah', 4);
insert into person(id, name, company_id)
values (15, 'Daniel', 5);
insert into person(id, name, company_id)
values (16, 'Katie', 5);
insert into person(id, name, company_id)
values (17, 'Maks', 5);
insert into person(id, name, company_id)
values (18, 'Hizer', 5);
insert into person(id, name, company_id)
values (19, 'Tom', 5);
-- получить имена всех person, которые не состоят в компании с id = 5;
-- название компании для каждого человека
select p.name as name, c.name as company
from person p
         left join company c on p.company_id = c.id
where c.id != 5;
-- выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select c.name as company, count(p.name) as people
from person p
         right join company c on p.company_id = c.id
group by c.name
having count(p.name) = (select max(m)
                        from (select count(p.name) as m
                              from person p
                                       right join company c on p.company_id = c.id
                              group by c.name) as q);