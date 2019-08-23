create table users
(
    id       serial       not null
        constraint users_pk
            primary key,
    name     varchar(50),
    login    varchar(50)  not null,
    password varchar(200) not null
);

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);

create unique index users_login_uindex
    on users (login);

INSERT INTO public.users (id, name, login, password) VALUES (8, 'Леонид2', 'adm1', '');
INSERT INTO public.users (id, name, login, password) VALUES (9, 'Василий', 'student', '2');