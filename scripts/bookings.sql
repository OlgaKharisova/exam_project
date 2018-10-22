CREATE TABLE public.bookings
(
    id bigserial PRIMARY KEY NOT NULL,
    timestamp timestamp NOT NULL,
    client bigserial NOT NULL,
    tour bigserial NOT NULL
);
CREATE UNIQUE INDEX bookings_id_uindex ON public.bookings (id);