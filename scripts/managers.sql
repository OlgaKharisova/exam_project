CREATE TABLE public.managers
(
  id int PRIMARY KEY NOT NULL,
  name varchar(256) NOT NULL,
  secondName varchar(256) NOT NULL,
  patronymic varchar(256) NOT NULL,
  email varchar(64) NOT NULL
);
CREATE UNIQUE INDEX managers_id_uindex ON public.managers (id);
CREATE UNIQUE INDEX managers_email_uindex ON public.managers (email);
