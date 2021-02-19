create database example;
create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);
insert into devices(name, price) VALUES ('Телефон1', 10500.50);
insert into devices(name, price) VALUES ('Телефон2', 20500.50);
insert into devices(name, price) VALUES ('Телефон3', 30500.70);
insert into devices(name, price) VALUES ('Ноутбук1', 25500.10);
insert into devices(name, price) VALUES ('Ноутбук2', 47500.40);
insert into devices(name, price) VALUES ('Ноутбук3', 33500.30);
insert into devices(name, price) VALUES ('Планшет', 25500.10);
insert into devices(name, price) VALUES ('Холодильник', 31500.40);
insert into devices(name, price) VALUES ('Телевизор', 27500.30);
insert into devices(name, price) VALUES ('Умный браслет', 2700.10);
select * from devices;
insert into people(name) values ('Василий');
insert into people(name) values ('Виталий');
insert into people(name) values ('Жанна');
select * from people;
insert into devices_people(device_id, people_id) VALUES (1, 1);
insert into devices_people(device_id, people_id) VALUES (2, 2);
insert into devices_people(device_id, people_id) VALUES (3, 3);
insert into devices_people(device_id, people_id) VALUES (4, 1);
insert into devices_people(device_id, people_id) VALUES (5, 2);
insert into devices_people(device_id, people_id) VALUES (6, 3);
insert into devices_people(device_id, people_id) VALUES (7, 2);
insert into devices_people(device_id, people_id) VALUES (8, 1);
insert into devices_people(device_id, people_id) VALUES (8, 2);
insert into devices_people(device_id, people_id) VALUES (8, 3);
insert into devices_people(device_id, people_id) VALUES (9, 3);
insert into devices_people(device_id, people_id) VALUES (10, 1);
insert into devices_people(device_id, people_id) VALUES (10, 2);
select * from devices_people;
-- средняя цена устройств
select avg(price) as avg_price from devices;
-- для каждого человека средняя цена его устройств
select
       p.name,
       avg(d.price)
from people as p
join devices_people dp on p.id = dp.people_id
join devices d on d.id = dp.device_id
group by p.name;
-- см. выше + цена устройства должна быть больше 5000
select
       p.name,
       round(avg(d.price)) as avg_price
from people as p
join devices_people dp on p.id = dp.people_id
join devices d on d.id = dp.device_id
where d.price > 5000
group by p.name;