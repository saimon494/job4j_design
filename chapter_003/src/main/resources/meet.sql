create table person
(
    id   serial primary key,
    name varchar(255)
);
create table meet
(
    id   serial primary key,
    name varchar(255)
);
create table person_meet
(
    id         serial primary key,
    person_id int references person (id),
    meet_id  int references meet (id),
    status bool
);
insert into person(name) values ('Person 1');
insert into person(name) values ('Person 2');
insert into person(name) values ('Person 3');
insert into person(name) values ('Person 4');
insert into person(name) values ('Person 5');
insert into person(name) values ('Person 6');
insert into person(name) values ('Person 7');
insert into person(name) values ('Person 8');
insert into person(name) values ('Person 9');
insert into person(name) values ('Person 10');
select * from person;
insert into meet(name) values ('Meeting 1');
insert into meet(name) values ('Meeting 2');
insert into meet(name) values ('Meeting 3');
insert into meet(name) values ('Meeting 4');
insert into meet(name) values ('Meeting 5');
select * from meet;
insert into person_meet(person_id, meet_id, status) values (1, 1, true);
insert into person_meet(person_id, meet_id, status) values (2, 1, false);
insert into person_meet(person_id, meet_id, status) values (3, 1, true);
insert into person_meet(person_id, meet_id, status) values (4, 2, true);
insert into person_meet(person_id, meet_id, status) values (5, 2, false);
insert into person_meet(person_id, meet_id, status) values (1, 3, true);
insert into person_meet(person_id, meet_id, status) values (6, 3, true);
insert into person_meet(person_id, meet_id, status) values (8, 3, true);
insert into person_meet(person_id, meet_id, status) values (9, 3, false);
insert into person_meet(person_id, meet_id, status) values (10, 3, true);
insert into person_meet(person_id, meet_id, status) values (3, 5, false);
insert into person_meet(person_id, meet_id, status) values (5, 5, true);
insert into person_meet(person_id, meet_id, status) values (7, 5, true);
insert into person_meet(person_id, meet_id, status) values (8, 5, true);
insert into person_meet(person_id, meet_id, status) values (9, 5, false);
select * from person_meet;
-- Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.
select count(person_id) as number_of_request,
       (select count(person_id)
        from person_meet
        where status = true) as person_approved
from person_meet;
-- Нужно получить все совещания, где не было ни одной заявки на посещения
select name from meet m
                     left join person_meet pm
                               on m.id = pm.meet_id
where pm.person_id is null;