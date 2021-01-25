create database phones;
create table phones(
                       id serial primary key,
                       name text,
                       nfc bool,
                       ram int
);
insert into phones (name, nfc, ram)
values ('Xiaomi', true, 4);
select * from phones;
update phones set ram = 6;
delete from phones;