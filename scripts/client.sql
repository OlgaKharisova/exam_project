CREATE TABLE public.clients
(
    id int PRIMARY KEY NOT NULL,
    name varchar(256) NOT NULL,
    secondName varchar(256) NOT NULL,
    patronymic varchar(256) NOT NULL,
    email varchar(64) NOT NULL
);
CREATE UNIQUE INDEX clients_id_uindex ON public.clients (id);
CREATE UNIQUE INDEX clients_email_uindex ON public.clients (email);
