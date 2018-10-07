CREATE TABLE public.tours
(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  tourPrice double precision NOT NULL,
  flightPrice double precision NOT NULL,
  startDate TIMESTAMP NOT NULL,
  endDate timestamp NOT NULL,
  maxParticipants int NOT NULL,
  tourStatus VARCHAR(64) NOT NULL,
  creator BIGSERIAL NOT NULL,
  description VARCHAR(1024) NOT NULL,
  CONSTRAINT tours_managers_id_fk FOREIGN KEY (creator) REFERENCES public.managers (id)
);
CREATE UNIQUE INDEX tours_id_uindex ON public.tours (id);