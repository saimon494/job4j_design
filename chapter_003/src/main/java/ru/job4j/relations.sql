-- many-to-one
create table position(
    id serial primary key,
    name varchar(255)
);
create table employees(
                          id serial primary key,
                          name varchar(255),
                          position_id int references position(id)
);
insert into position(name) values ('programmer');
insert into employees(name, position_id) values ('Ivan', 1);
select * from employees;
select * from position where id in (select id from employees);

-- many-to-many
create table students(
                         id serial primary key,
                         name varchar(255)
);
create table courses(
                        id serial primary key,
                        name varchar(255)
);
create table students_courses
(
    id         serial primary key,
    student_id int references students (id),
    course_id  int references courses (id)
);
insert into students(name) values ('Ivan');
insert into students(name) values ('Kirill');
insert into students(name) values ('Roman');
insert into courses(name) values ('Java SE');
insert into courses(name) values ('Spring');
insert into courses(name) values ('Hibernate');
insert into students_courses(student_id, course_id) values (1, 1);
insert into students_courses(student_id, course_id) values (1, 2);
insert into students_courses(student_id, course_id) values (1, 3);
insert into students_courses(student_id, course_id) values (2, 1);
insert into students_courses(student_id, course_id) values (2, 2);
insert into students_courses(student_id, course_id) values (1, 3);
select * from students_courses;

-- one-to-one
create table passport(
                         id serial primary key,
                         seria int,
                         number int
);
create table people(
                       id serial primary key,
                       name varchar(255),
                       passport_id int references passport(id) unique
);
insert into passport(seria, number) VALUES (1, 1234);
insert into people(name, passport_id) VALUES ('Vova', 1);
select * from people;