CREATE TABLE public.bookings
(
    id bigserial PRIMARY KEY NOT NULL,
    timestamp timestamp NOT NULL,
    clientId bigserial NOT NULL,
    tourId bigserial NOT NULL
);
CREATE UNIQUE INDEX bookings_id_uindex ON public.bookings (id);