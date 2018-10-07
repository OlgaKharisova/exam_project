CREATE TABLE public.bookings
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    timestamp timestamp NOT NULL,
    client BIGSERIAL NOT NULL,
    tour BIGSERIAL NOT NULL,
    CONSTRAINT bookings_clients_id_fk FOREIGN KEY (client) REFERENCES public.clients (id),
    CONSTRAINT bookings_tours_id_fk FOREIGN KEY (tour) REFERENCES public.tours (id)
);
CREATE UNIQUE INDEX bookings_id_uindex ON public.bookings (id);