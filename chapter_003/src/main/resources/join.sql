create database example;
-- Создать таблицы
create table departments
(
    id   serial primary key,
    name varchar(255)
);
create table employees
(
    id   serial primary key,
    name varchar(255),
    department_id int references departments(id)
);
-- заполнить их начальными данными
insert into departments(name) values ('dep1');
insert into departments(name) values ('dep2');
insert into departments(name) values ('dep3');
insert into departments(name) values ('dep4');
select * from departments;
insert into employees(name, department_id) values ('emp 1', 1);
insert into employees(name, department_id) values ('emp 2', 1);
insert into employees(name, department_id) values ('emp 3', 1);
insert into employees(name, department_id) values ('emp 4', 2);
insert into employees(name, department_id) values ('emp 5', 2);
insert into employees(name, department_id) values ('emp 6', null);
insert into employees(name, department_id) values ('emp 7', 3);
insert into employees(name, department_id) values ('emp 8', null);
insert into employees(name, department_id) values ('emp 9', 3);
insert into employees(name, department_id) values ('emp 10', 3);
select * from employees;
-- Выполнить запросы с left, right, full, cross соединениями
select * from employees e left join departments d on e.department_id = d.id;
select * from employees e right join departments d on e.department_id = d.id;
select * from employees e full join departments d on e.department_id = d.id;
select * from employees e left join departments d on e.department_id = d.id
union
select * from employees e right join departments d on e.department_id = d.id;
select * from employees e cross join departments d;
-- Используя left join найти департаменты, у которых нет работников
select d.name from departments d left join employees e on d.id = e.department_id
where e.department_id is null;
-- Используя left и right join написать запросы, которые давали бы одинаковый результат
select * from employees e left join departments d on e.department_id = d.id;
select * from departments d right join employees e on d.id = e.department_id;
-- Создать таблицу teens с атрибутами name, gender и заполнить ее
create table teens(
                      name varchar(255),
                      gender varchar(255)
);
insert into teens(name, gender) values('Иван', 'm');
insert into teens(name, gender) values('Александр', 'm');
insert into teens(name, gender) values('Ольга', 'f');
insert into teens(name, gender) values('Василий', 'm');
insert into teens(name, gender) values('Татьяна', 'f');
insert into teens(name, gender) values('Светлана', 'f');
insert into teens(name, gender) values('Виктор', 'm');
insert into teens(name, gender) values('Ирина', 'f');
select * from teens;
-- Используя cross join составить все возможные разнополые пары
select t1.name as teen1, t2.name as teen2 from teens t1 cross join teens t2
where t1.gender != t2.gender and t1.gender like 'm';