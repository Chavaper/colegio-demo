drop table if exists profesor;
drop table if exists curso;
drop type if exists tipo_profesor;

CREATE TYPE tipo_profesor AS ENUM (
    'P',
    'TP',
    'A'
);

create table profesor(
    id int generated always as identity primary key,
    nombre varchar(60) not null,
    apellido varchar(60) not null,
    tipo tipo_profesor not null
);

create table curso(
    id int generated always as identity primary key,
    nombre varchar(60) not null,
    id_profesor int,
    constraint fk_curso_profesor
        foreign key (id_profesor) references profesor(id)
);