create database example;
create table type(
                     id serial primary key,
                     name varchar(255)
);
create table product(
                        id serial primary key,
                        name varchar(255),
                        type_id int references type(id),
                        expired_date date,
                        price float
);
insert into type(name) values ('Сыр');
insert into type(name) values ('Молоко');
insert into type(name) values ('Замороженные продукты');
select * from type;
insert into product(name, type_id, expired_date, price)
VALUES ('Viola', 1, '2021-10-01', 169.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Oltermanni', 1, '2021-10-03', 539.00);
insert into product(name, type_id, expired_date, price)
VALUES ('VeroCheese', 1, '2021-08-01', 549.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Простоквашино', 2, '2021-02-14', 68.90);
insert into product(name, type_id, expired_date, price)
VALUES ('Parmalat', 2, '2021-12-01', 90.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Домик в деревне', 2, '2021-12-01', 72.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Смесь овощная', 3, '2023-02-01', 87.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Капуста брокколи', 3, '2023-02-01', 129.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Мороженое Лакомка', 3, '2022-05-01', 46.00);
insert into product(name, type_id, expired_date, price)
VALUES ('Мороженое Коровка', 3, '2023-05-01', 59.90);
select * from product;
-- все продукты с типом "СЫР"
select p.name, t.name
from product p
         join type t on p.type_id = t.id
where t.name = 'Сыр';
-- все продукты, у кого в имени есть слово "мороженное"
select p.name
from product p
         join type t on p.type_id = t.id
where p.name like '%Мороженое%';
-- продукты, срок годности которых заканчивается в следующем месяце
select p.name, t.name, p.expired_date
from product p
         join type t on p.type_id = t.id
where p.expired_date < current_date + 31;
-- самый дорогой продукт
select name, price as max_price
from product
where price = (select max(price) from product);
-- количество всех продуктов определенного типа
select t.name, count(t.name)
from type t
         join product p on p.type_id = t.id
group by t.name;
-- все продукты с типом "СЫР" и "МОЛОКО"
select p.name as name, t.name as type
from product p
         join type t on p.type_id = t.id
where t.name = 'Сыр' or t.name = 'Молоко';
-- тип продуктов, которых осталось меньше 10 штук
select t.name, count(t.name)
from type t
         join product p on p.type_id = t.id
group by t.name
having count(t.name) < 10;
-- все продукты и их тип
select p.name as name, t.name as type
from product p
         join type t on p.type_id = t.id;