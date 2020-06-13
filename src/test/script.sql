-- Для создания бд

create table city
(
    id                 serial primary key,
    city_name          varchar(255),
    year_of_foundation int,
    square            int
);

create table type_of_people(
                               id serial primary key ,
                               city_id int,
                               name_type_of_people varchar(255),
                               language_of_communication varchar(255),
                               foreign key (city_id) references city(id)
);

create table list_of_people(
                               id serial primary key ,
                               city_id int,
                               type_of_people_id int,
                               count int,
                               foreign key (type_of_people_id) references type_of_people(id),
                               foreign key (city_id) references city(id)
);

insert into city (city_name, year_of_foundation, square)
values ('Moscow',1917,2511);
insert into city (city_name, year_of_foundation, square)
values ('Saint-Petersburg',1703,1439);
insert into type_of_people(city_id, name_type_of_people, language_of_communication) values (1, 'Russian', 'Russian');
insert into type_of_people(city_id, name_type_of_people, language_of_communication) values (2, 'Russian', 'Russian');
insert into type_of_people(city_id, name_type_of_people, language_of_communication) VALUES (1, 'Armenian', 'Russian');
insert into  list_of_people(city_id, type_of_people_id, count) VALUES (1,1,10000000);
insert into  list_of_people(city_id, type_of_people_id, count) VALUES (2,2,500000);


