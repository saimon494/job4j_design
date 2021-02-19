create database example;
-- Таблицы: Кузов, Двигатель, Коробка передач.
create table body(
                     id serial primary key,
                     name varchar(255)
);
create table engine(
                       id serial primary key,
                       name varchar(255)
);
create table transmission(
                             id serial primary key,
                             name varchar(255)
);
-- Создать структуру Машина. Машина не может существовать без данных из п.1.
create table car(
                    id serial primary key,
                    name varchar(255),
                    body_id int references body(id),
                    engine_id int references engine(id),
                    transmission_id int references transmission(id)
);
-- Заполнить таблицы через insert.
insert into body(name) values('Sedan');
insert into body(name) values('Hatchback');
insert into body(name) values('SUV');
insert into body(name) values('Wagon');
insert into body(name) values('Coupe');
insert into engine(name) values('VAG 1.4 TSI');
insert into engine(name) values('OPEL 1.4');
insert into engine(name) values('MERCEDES-BENZ 1.6');
insert into engine(name) values('NISSAN 1.6');
insert into engine(name) values('FORD 1.5');
insert into engine(name) values('MAZDA SKYACTIV');
insert into engine(name) values('RENAULT 1.6');
insert into engine(name) values('VAG 1.6');
insert into engine(name) values('TOYOTA 1.6');
insert into engine(name) values('HONDA 2.0');
insert into transmission(name) values('Manual');
insert into transmission(name) values('Automatic');
insert into transmission(name) values('Robot');
insert into transmission(name) values('CVT');
insert into car(name, body_id, engine_id, transmission_id) values('VW Jetta', 1, 8, 2);
insert into car(name, body_id, engine_id, transmission_id) values('VW Jetta', 1, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values('VW Polo', 2, 1, 3);
insert into car(name, body_id, engine_id, transmission_id) values('VW Tiguan', 3, 1, 3);
insert into car(name, body_id, engine_id, transmission_id) values('Opel Astra', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('MERCEDES-BENZ C', 1, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Mercedes-Benz C Coupe', 5, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Nissan Terrano', 3, 4, 1);
insert into car(name, body_id, engine_id, transmission_id) values('Ford Ecosport', 3, 5, 1);
insert into car(name, body_id, engine_id, transmission_id) values('Mazda 6', 1, 6, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Mazda CX-5', 3, 6, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Renault Arkana', 3, 7, 4);
insert into car(name, body_id, engine_id, transmission_id) values('Renault Logan', 1, 7, 1);
insert into car(name, body_id, engine_id, transmission_id) values('Toyota Corolla', 1, 9, 4);
insert into car(name, body_id, engine_id, transmission_id) values('Honda CR-V', 3, 10, 4);
select * from car;
-- Вывести список всех машин и все привязанные к ним детали.
select c.id, c.name as car, b.name as body, e.name as engine, t.name as transmission
from car c
         left join body b on c.body_id = b.id
         left join engine e on c.engine_id = e.id
         left join transmission t on c.transmission_id = t.id;
-- Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select b.name as body
from body b
         left join car c on b.id = c.body_id
where c.id is null;
select e.name as engine
from engine e
         left join car c on e.id = c.engine_id
where c.id is null;
select t.name as transmission
from transmission t
         left join car c on t.id = c.transmission_id
where c.id is null;